(ns app.pages.home
  (:require ["/components/Anchor" :refer [Anchor]]))

(defn splash-page []
 [:div.mx-8.my-16.md:mx-32
  [:section
   [:h1.text-7xl.text-bold.font-display "Vishal Gautam"]
   [:h3.text-3xl.mt-4.font-body "Software Engineer"]]
  [:section.mt-24
   [:h1.text-4xl.font-display "Tutorials"]
   [:ul.mt-8.mx-8
    [:h3.text-xl.mt-4.font-body
     [:a {:href "https://www.youtube.com/watch?v=fgOfYyTeBaQ&ab_channel=EngineeringwithV"
          :target "_blank"}
      "Basic Clojure Server + Integrant"]]
    [:h3.text-xl.mt-4.font-body
     [:a {:href "https://www.youtube.com/watch?v=QYJeHyd47tM&ab_channel=EngineeringwithV"
          :target "_blank"}
      "Getting Started with datomic dev-local"]]]]])

(defn home-page []
  [splash-page])
