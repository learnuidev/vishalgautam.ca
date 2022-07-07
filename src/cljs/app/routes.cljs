(ns app.routes
  (:require [reagent.core :as r]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.frontend.controllers :as rfc]
            [reitit.coercion.spec :as rss]
            ;; pages
            [app.pages.tutorials :refer [tutorials-page]]
            [app.pages.resume :refer [resume-page]]
            [app.pages.home :refer [home-page]]
            [app.pages.login :refer [login-page]]
            [app.pages.register :refer [register-page]]
            [app.pages.settings :refer [settings-page]]
            [app.pages.profile :refer [profile-page]]
            [app.pages.book :refer [book-page]]
            [app.pages.books :refer [books-page]]
            [app.pages.chapter :refer [chapter-page]]))


(defonce routes-state (r/atom nil))

(defonce temp (atom nil))

(comment
  @temp)

(def routes
  [["/"         {:name :routes/home
                 :view #'home-page}]
   ["/login"    {:name :routes/login
                 :view #'login-page
                 :controllers [{:start #(js/console.log "enter - login page")
                                :stop #(js/console.log  "exit - login page")}]}]
   ["/register" {:name :routes/register
                 :view #'register-page}]
   ["/settings" {:name :routes/settings
                 :view #'settings-page}]
   ["/resume" {:name :routes/resume
               :view #'resume-page}]
   ["/books" {:name :routes/books
              :view #'books-page}]
   ["/books/:bookId" {:name :routes/book
                      :view #'book-page}]
   ["/books/:bookId/chapters/:chapterId" {:name :routes/chapter
                                          :view #'chapter-page}]
   ["/tutorials" {:name :routes/tutorials
                  :view #'tutorials-page}]
   ["/user/:username" {:name :routes/profile
                       :view #'profile-page
                       :parameters
                       {:path {:username string?}}}]])

(comment "takes route name and generates the route path, nil if not found"
         (rfe/href ::login))


(comment
  @routes-state)

(defn router-start! []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion
                             :controllers [{:start (fn [] (println "Root controller start"))
                                            :stop #(println "Root controller stop")}]}})
   (fn [new-match] (swap! routes-state (fn [old-match]
                                         (if new-match
                                           (assoc new-match :controllers (rfc/apply-controllers (:controllers old-match) new-match))))))
    ;; set to false to enable HistoryAPI
   {:use-fragment false}))
