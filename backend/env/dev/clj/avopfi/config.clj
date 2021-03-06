(ns avopfi.config
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [avopfi.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[avopfi started successfully using the development profile]=-"))
   :middleware wrap-dev})
