(ns avopfi.routes.api
  (:require [avopfi.layout :as layout]
            [buddy.auth :refer [throw-unauthorized]]
            [clojure.java.data :refer :all]
            [avopfi.consts :refer :all]
            [avopfi.util :refer :all]
            [avopfi.integration.virta :as virta]
            [avopfi.integration.opintopolku :as op]
            [avopfi.integration.arvo :as arvo]
            [avopfi.db.core :as db]
            [config.core :refer [env]]
            [compojure.core :refer :all]
            [ring.util.http-response :refer :all]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]
            [avopfi.validator :refer [validate]]))

(defn home-page []
  (layout/render
   "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn opiskeluoikeus->ui-map
  [messages {:keys [avain myontaja tyyppi alkuPvm] jaksot :jakso {laajuus :opintopiste} :laajuus}]
  (let [{kunta-id :koulutuskunta :keys [luokittelu koulutuskoodi koulutuskieli]}
        (virta/select-active-timespan jaksot)
        kunta (op/extract-metadata (op/get-kunta-data kunta-id))
        koulutus (op/extract-metadata (op/get-koulutus-data koulutuskoodi))
        koulutustyyppi (virta/conclude-study-type tyyppi luokittelu)
        oppilaitos (op/extract-metadata (op/get-oppilaitos-data myontaja))]
    {
     :id avain
     :aloituspvm alkuPvm
     :kunta {:id kunta-id :nimi kunta}
     :kieli koulutuskieli
     :koulutus {:id koulutuskoodi :nimi koulutus}
     :koulutusmuoto koulutustyyppi
     :opiskeluoikeustyyppi tyyppi
     :laajuus laajuus
     :jakso jaksot
     :oppilaitos {:id myontaja :nimi oppilaitos}
     :virheet (map #(clojure.string/replace (name %) "-" "_") messages)}))

(defn to-ui [type oikeudet]
  (let [oikeudet (get oikeudet type)]
    (map #(opiskeluoikeus->ui-map (:messages %) (:oikeus %)) oikeudet)))


(defn get-oppilaitos-code-by-domain [domain]
  (let [mapping (db/get-mapping-by-domain {:domain domain})]
    (:code mapping)))

(defn shibbo-vals->opiskeluoikeudet [shibbo-vals tyyppi]
  (let [home-organization (shibbo-vals "home-organization")
        oppilaitos-id (get-oppilaitos-code-by-domain home-organization)
        virta-oikeudet (virta/get-virta-opiskeluoikeudet shibbo-vals oppilaitos-id)
        virta-suoritukset (virta/get-virta-suoritukset shibbo-vals oppilaitos-id)
        validated-oikeudet (->> (validate virta-oikeudet virta-suoritukset oppilaitos-id tyyppi))
        oikeudet {:valid (to-ui :valid validated-oikeudet)
                  :invalid (to-ui :invalid validated-oikeudet)
                  :oppilaitos_id oppilaitos-id}]
    oikeudet))

(defn debug-status [{:keys [session headers identity] :as request}]
  (if (:is-dev env)
    (ok {
         :headers headers
         :shibbo identity
         :oo (:opiskeluoikeudet-data session)})
    (not-found {})))

(defn process-registration [{params :body-params session :session}]
  (let [current-srid (:opiskeluoikeus_id params)
        oppilaitos (:oppilaitos_id params)
        kieli (:kieli params)
        opiskeluoikeudet-data (:opiskeluoikeudet-data session)
        opiskeluoikeus (some #(when (= current-srid (:id %)) %) opiskeluoikeudet-data)]
    (if opiskeluoikeus
      (let [res (db/get-visitor {:opiskeluoikeus_id current-srid :oppilaitos_id oppilaitos})]
        (if (nil? res)
          (let [arvo-hash
                (arvo/generate-questionnaire-credentials! opiskeluoikeus kieli)]
            (db/create-visitor! {:taustatiedot {:opiskeluoikeus current-srid
                                                :oppilaitos (-> opiskeluoikeus :oppilaitos :id)
                                                :kunta (-> opiskeluoikeus :kunta :id)
                                                :aloituspvm (-> opiskeluoikeus :aloituspvm)
                                                :kieli (-> opiskeluoikeus :kieli)
                                                :koulutus (-> opiskeluoikeus :koulutus :id)}
                                 :vastaajatunnus arvo-hash})
            (ok {:kysely_url (str
                              (:arvo-answer-url env) arvo-hash "/" kieli)}))
          ;; No obviously obvious status code when entity is duplicate,
          ;; (mis)using 422 as some other application/frameworks here.
          (unprocessable-entity
           {:status 422 :detail "Entity already exists" :kysely_url
            (str (:arvo-answer-url env) (:vastaajatunnus res) "/" kieli)})))
      (throw-unauthorized))))

(defn opiskeluoikeudet [request]
  (let [shibbo-vals (:identity request)
        tyyppi (-> request :route-params :tyyppi keyword)]
      (let [session (:session request)
            resp-data (shibbo-vals->opiskeluoikeudet shibbo-vals tyyppi)]
        (-> (ok resp-data)
            (assoc :session
                   (assoc session :opiskeluoikeudet-data
                                  (:valid resp-data)))))))

(defroutes api-routes
  (context
      "/api" []
    (GET "/" [] (home-page))
    (GET "/opiskeluoikeudet/:tyyppi" request
      (opiskeluoikeudet request))
    (POST "/rekisteroidy" request
      (process-registration request))
    (GET "/status" request
      (debug-status request)))
  (GET "/" [] (found "/api")))
