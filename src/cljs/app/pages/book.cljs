(ns app.pages.book)


(def contents
  [{:title "Introduction"
    :href "/book"}
   {:title "Basic Server with Ring"
    :href "/book"}
   {:title "Data Driven Architecture Integrant"
    :href "/book"}
   {:title "Routing with Reitit"
    :href "/book"}
   {:title "Introduction Datomic"
    :href "/book"}
   {:title "Deploying our Application using Datomic Ion"
    :href "/book"}
   {:title "Reitit - Part II"
    :href "/book"}])



(defn book-page []
  [:div.mx-8.my-16.md:mx-32
   [:h1.text-4xl.font-bold.flex.items-center.justify-center "Contents"]
   [:div.mt-8.space-y-5
    (for [{:keys [title href]} contents]
     ^{:key title}
      [:a.text-xl.block {:href href}
       title])]])
