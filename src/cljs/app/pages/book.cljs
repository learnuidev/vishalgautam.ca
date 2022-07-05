(ns app.pages.book)


(def contents
  [{:title "Introduction"
    :href "/book"}
   {:title "Basic Server with Ring"
    :href "/book"}
   {:title "Data Driven Architecture with Integrant"
    :href "/book"}
   {:title "Routing with Reitit"
    :href "/book"}
   {:title "Introduction to Datomic, an Immutable Database"
    :href "/book"}
   {:title "Deploying our Application using Datomic Ion"
    :href "/book"}
   {:title "Reitit - Part II"
    :href "/book"}])



(defn book-page []
  [:div.mx-8.my-16.md:mx-64
   [:h1.text-4xl.font-bold.font-display.flex.items-center.justify-center "Contents"]
   [:div.mt-8.space-y-7
    (for [{:keys [title href]} contents]
     ^{:key title}
      [:a.text-2xl.block {:href href}
       title])]])
