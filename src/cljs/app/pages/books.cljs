(ns app.pages.books
  (:require [app.books.immutable-stack :as book]))

(defn books-page []
  [:div.mx-8.my-16.md:mx-64
   [:h1.text-4xl.font-bold.font-display.flex.items-center.justify-center "Contents"]
   [:div.mt-8.space-y-7
    (for [{:keys [title href]} book/contents]
     ^{:key title}
      [:a.text-2xl.block {:href href}
       title])]])
