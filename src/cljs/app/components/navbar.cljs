(ns app.components.navbar
  ;; TODO: tech debt: refactor
  (:require [app.routes :refer [routes-state]]))

(comment
  (-> @routes-state :data :name))


(defn is-active? [rs route-name]
    (= (-> rs :data :name)
       route-name))

(comment
  (is-active? @routes-state :routes/home)
  (is-active? @routes-state :routes/restaurants))



(defn navbar []
  [:nav.m-8.flex.justify-between.items-stretch.items-center.md:mx-64.my-16
   [:a {:href "/"}
    [:p.text-bold.font-display.text-lg "V"]]
   [:div.flex.grid-gap-2
    [:p.text-xl.mx-4 {:class [(when (is-active? @routes-state :routes/tutorials) "font-medium")]}
     [:a {:href "/tutorials"} "tutorials"]]
    [:p.text-xl.mx-4 {:class [(when (is-active? @routes-state :routes/book) "font-medium")]}
     [:a {:href "/books/immutable-stack"} "immutable stack"]]]])
