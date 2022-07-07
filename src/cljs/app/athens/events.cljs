(ns app.athens.events
  (:require [re-frame.core :as rf]
            [app.athens.db :as db]
            [app.athens.db.init-db :refer [init-db]]
            [app.athens.common-db :as common-db]))

(rf/reg-event-fx
 :boot
 (fn [_ _]
   {:db init-db}))
