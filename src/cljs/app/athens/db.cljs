(ns app.athens.db
  (:require [datascript.core :as d]
            [posh.reagent :as p]
            [app.athens.common-db :refer [create-conn]]
            [app.athens.parser.impl :as parser]))

(comment
  (parser/staged-parser->ast "### Hello \n hello"))


(defonce dsdb (create-conn))

(p/posh! dsdb)

(comment
  (d/schema @dsdb))
