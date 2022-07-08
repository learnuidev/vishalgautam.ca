(ns app.athens.db
  (:require [datascript.core :as d]
            [posh.reagent :as p]
            [app.athens.common.utils :as utils]
            [app.athens.common-db :refer [create-conn]]
            [app.athens.parser.impl :as parser]))

(comment
  (utils/gen-block-uid)
  (parser/staged-parser->ast "### Hello \n hello"))


(defonce dsdb (create-conn))

(p/posh! dsdb)

(comment
  (d/schema @dsdb))
