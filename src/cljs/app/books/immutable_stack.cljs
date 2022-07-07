(ns app.books.immutable-stack
  (:require [app.utils :refer [index-by]]))

(def contents
  [{:title "Introduction"
    :id "01-introduction"
    :href "/books/immutable-stack/chapters/01-introduction"}
   {:title "Basic Server with Ring"
    :id "02-ring"
    :href "/books/immutable-stack/chapters/02-ring"}
   {:title "Data Driven Architecture with Integrant"
    :id "03-integrant"
    :href "/books/immutable-stack/chapters/03-integrant"}
   {:title "Routing with Reitit"
    :id "04-reitit"
    :href "/books/immutable-stack/chapters/04-reitit"}
   {:title "Introduction to Datomic, an Immutable Database"
    :id "05-datomic"
    :href "/books/immutable-stack/chapters/05-datomic"}
   {:title "Deploying our Application using Datomic Ion"
    :id "06-deployment"
    :href "/books/immutable-stack/chapters/06-deployment"}
   {:title "Reitit - Part II"
    :id "07-reitit-2"
    :href "/books/immutable-stack/chapters/07-reitit-2"}])


(def book (index-by contents :id))
