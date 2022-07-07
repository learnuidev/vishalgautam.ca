(ns app.utils)

(defn index-by [coll key-fn]
  (into {} (map (juxt key-fn identity) coll)))
