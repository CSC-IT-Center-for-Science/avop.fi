let localizations_fi = {
  header: {
    logotext: 'Ammattikorkeakoulujen valmistumisvaiheen opiskelijapalaute',
    header_alt: 'Kyselyn logo'
  },
  content: {
    kysely: {
      information: 'Tietoa kyselystä',
      about1: 'AVOP on palautekysely, jossa opiskelija arvioi ja antaa palautetta toteutuneesta koulutuksesta. Kyselyn tuloksia hyödynnetään sekä paikallisesti korkeakoulun oman toiminnan kehittämisessä että valtakunnallisesti koulutuksen ohjauksessa ja rahoituksessa. Kyselyn täyttävät kaikki ammattikorkeakouluista valmistuvat tutkinto-opiskelijat.',
      about2: 'Opiskelijan HAKA-kirjautumisen avulla haetaan henkilön opiskeluoikeuteen liittyviä tietoja VIRTA-opintotietopalvelusta taustatiedoksi AVOP-kyselyn vastaajatunnuksen luomiseksi ja sähköisen palautteen antamisen mahdollistamiseksi. Henkilön yksilöiviä tunnisteita ei välitetä eteenpäin itse AVOP-kyselyyn ja annettua palautetta käsitellään anonyymisti.',
      about3: 'AVOP-kyselymittaristo on syntynyt Ammattikorkeakoulujen rehtorineuvosto Arene ry:n, Suomen opiskelijakuntien SAMOK ry:n, Opiskelun ja koulutuksen tutkimussäätiön (OTUS) ja opetus- ja kulttuuriministeriön (OKM) yhteisenä hankkeena. Kyselymittariston käyttöönotosta ja sen kehittämisestä vastaa Arene ry.',
      privacy: {
        text: 'Lisätietoa: %(link1)s ja %(link2)s.',
        privacyLink: './privacy_fi.pdf',
        privacyLinkText: 'tietosuojaseloste',
        accessibilityLink: 'https://arvokyselyt.fi/documents/accessibility_statement_FI.html',
        accessibilityLinkText: 'saavutettavuusseloste',
      }
    },
    login: {
      header: 'Ammattikorkeakouluopiskelija',
      description: 'Vastaa kyselyyn kirjautumalla oman korkeakoulusi tunnuksilla:'
    },
    tulokset: {
      header: 'Kyselyn tulokset',
      results1: 'Ammattikorkeakoulujen henkilökunta voi tarkastella kyselyn tuloksia reaaliaikaisesti Arvo - opetushallinnon vaikuttavuustietopalvelun avulla. Katseluoikeudet (Arvo-katselija) voi anoa Opintopolun virkailijantyöpöydän kautta (Omat tiedot)',
      results2: 'Kyselyn tuloksista johdettuja tilastoraportteja on avoimesti saatavilla ',
      results_link: 'opetushallinnon tilastopalvelu Vipusessa.'
    }
  },
  footer: {
    header: 'Yhteistyössä:',
    arene: {
      description: 'Ammattikorkeakoulujen rehtorineuvosto Arene ry',
      logo_alt: 'Arenen logo'
    },
    okm: {
      description: 'Opetus- ja kulttuuriministeriö',
      logo_alt: 'Opetus- ja kulttuuriministeriön logo'
    },
    csc: {
      description: 'Arvo - opetushallinnon vaikuttavuustietopalvelu',
      logo_alt: 'CSC - Tieteen tietotekniikan keskuksen logo'
    }
  },
  profiledata: {
    header: 'Palautekyselyn taustatiedot',
    about: 'Palautekyselyyn välitetään taustatiedoiksi koulutus, ammattikorkeakoulu, koulutuksen kunta, tutkinnon aloitusvuosi, tutkinnon suorituskieli ja koulutusmuoto. Henkilöön liittyviä tietoja ei välitetä palautekyselylle.',
    about_yamk: 'Palautekyselyyn välitetään taustatiedoiksi koulutus, ammattikorkeakoulu, koulutuksen kunta, tutkinnon aloitusvuosi ja tutkinnon suorituskieli. Henkilöön liittyviä tietoja ei välitetä palautekyselylle.',
    education: 'Tutkintonimike',
    school: 'Ammattikorkeakoulu',
    municipality: 'Kunta',
    startYear: 'Tutkinnon aloitusvuosi',
    language: 'Tutkinnon suorituskieli',
    form_of_education: 'Koulutusmuoto',
    reminder: 'Tarkistathan, että koulutuksesi tiedot ovat oikein. Siirtymällä palautekyselyyn hyväksyt tietojen käyttämisen palautekyselyn taustatietona.',
    survey: 'Siirry palautekyselyyn',
    type: {
      day: 'Päiväopiskelu',
      multi: 'Monimuoto-opiskelu'
    },
    submit: 'Siirry palautekyselyyn'
  },
  errors: {
    title: 'Virhetilanne',
    general_error: 'Valitettavasti järjestelmän toiminnassa tapahtui virhe. Jos ongelma toistuu, ole hyvä ja ota yhteys ylläpitoon arvo@csc.fi.',
    haka_error: 'Valitettavasti Haka ei luovuttanut kirjautumisesi yhteydessä vaadittuja tietoja, ota yhteys oppilaitokseesi.',
    virta_error: 'Virhe haettaessa tietojasi Virta-opintotietopalvelusta. ',
    no_data_in_virta: 'Valitettavasti kirjautumistietosi eivät vastaa Virta-opintotietopalvelusta löydettäviä tietoja. Ota yhteys oppilaitokseesi.',
    arvo_error: 'Valitettavasti palautekyselyyn siirtymisessä tapahtui virhe. Ota yhteys arvo@csc.fi.',
    attach_code: 'Liitä viestin tämä virhekoodi'
  },
  opiskeluoikeus_errors: {
    invalid_organization: 'Opiskeluoikeutesi ei kuulu HAKA-kirjaumista vastaavaan korkeakouluun.',
    invalid_type: 'Väärä tyyppi.',
    invalid_date: 'Opiskeluoikeutesi ei ole voimassa.',
    invalid_laajuus: 'Puuttellinen tieto opintorekisterissä.',
    not_enough_opintosuoritus: 'Sinulla ei ole tarvittavia suoritusmerkintöjä opintorekisterissä.',
    no_kandi: 'Sinulla ole kandidaatin tutkinnon suoritusmerkintää opintorekisterissä.',
    header: 'Opiskeluoikeuksia ei löydy',
    no_rights_contact_study_office: 'Tiedoillasi ei löytynyt yhtään opiskeluoikeutta. Ota yhteys opintotoimistoosi.',
    some_rights_contact_study_office: 'Tiedoillasi löytyi %(rights_count)s opiskeluoikeutta, mutta tiedot eivät riitä palautteen antamiseen. Ota yhteys opintotoimistoosi.',
    additional_invalid_rights: 'Lisäksi löytyi %(rights_count)s oikeutta, mutta tiedot eivät riitä palautteen antamiseen.'
  },
};

export default localizations_fi;
