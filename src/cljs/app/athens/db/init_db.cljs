(ns app.athens.db.init-db)


(def init-db
  {:athena/recent-items []
   :presence {}
   :current-route nil
   :win-fullscreen? false
   :loading? true
   :left-sidebar/open false
   :alert nil
   :daily-notes/items []
   :modal false
   :zoom-level 0
   :mouse-down false
   :athens/persist {:persist/version 3
                    :theme/dark false
                    :graph-conf {:hlt-link-levels 1
                                 :link-distance 50
                                 :charge-strength -15
                                 :local-depth 1
                                 :root-links-only?
                                 false
                                 :orphans? true
                                 :daily-notes? true}
                    :settings {:email nil
                               :username "Hephaestus"
                               :color "#21A469"
                               :monitoring true
                               :backup-time 15}
                    :db-picker/all-dbs {"In-memory DB" {:type :in-memory
                                                        :name "In-memory DB"
                                                        :id "In-memory DB"
                                                        :current-route/uid "ee770c334"
                                                        :current-route/title "uix"}}
                    :db-picker/selected-db-id "In-memory DB"}
   :win-focused? true
   :right-sidebar/items {}
   :right-sidebar/open false
   :help/open? false
   :win-maximized? false
   :right-sidebar/width 32
   :fs/watcher nil
   :selection {:items []}
   :connection-status :disconnected
   :db/mtime nil
   :athena/open false
   :db/synced true})
