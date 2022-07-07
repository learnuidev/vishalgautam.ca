(ns app.athens.db
  (:require [datascript.core :as d]
            [posh.reagent :as p]))

;; schemas
(def v1-schema
  {:schema/version      {}
   :block/uid           {:db/unique :db.unique/identity}
   :node/title          {:db/unique :db.unique/identity}
   :attrs/lookup        {:db/cardinality :db.cardinality/many}
   :block/children      {:db/cardinality :db.cardinality/many
                         :db/valueType   :db.type/ref}
   :block/refs          {:db/cardinality :db.cardinality/many
                         :db/valueType   :db.type/ref}
   ;; TODO: do we really still use it?
   :block/remote-id     {:db/unique :db.unique/identity}})


(def v2-schema
  {;; It would be nicer to have the reverse relationship here (:block/properties as a set
   ;; of children refs, instead :block/property-of as a single parent ref), but that doesn't
   ;; work with the tupleAttr below.
   :block/property-of     {:db/cardinality :db.cardinality/one
                           :db/valueType   :db.type/ref}
   ;; key is to a property what order is to a child
   :block/key             {:db/cardinality :db.cardinality/one
                           :db/valueType   :db.type/ref}
   ;; tupleAttrs are used here to ensure the relationship is unique,
   ;; that there are no repeat keys in a block.
   ;; https://github.com/tonsky/datascript/blob/master/docs/tuples.md
   ;; It could later be extended to also ensure order is unique.
   :block/property-of+key {:db/tupleAttrs [:block/property-of :block/key]
                           :db/unique     :db.unique/identity}})

;;
(defn transact-schema!
  [conn schema]
  (let [current-schema (d/schema @conn)
        merged-schema  (merge current-schema schema)]
    ;; NB: there is no way to update the schema of an existing conn.
    ;; This returns a new conn, any watchers will have to be added again.
    (reset! conn (-> (d/datoms @conn :eavt)
                     (d/conn-from-datoms merged-schema)
                     deref))))



(defn migrate! [conn]
  (transact-schema! conn v1-schema)
  (transact-schema! conn v2-schema))


(defn migrate-conn!
  [conn & {:as opts}]
  (migrate! conn)
  conn)


(defn create-conn
  []
  (migrate-conn! (d/create-conn)))

;;
(defonce dsdb (create-conn))

(comment
  (d/schema @dsdb))

;; === watch
(defn watch!
  "Watch the global datascript database."
  []
  (p/posh! dsdb))
