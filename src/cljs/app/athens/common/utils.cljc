(ns app.athens.common.utils
  "Athens Common Utilities.
  Shared between CLJ and CLJS.")

;; this is the function that generates new uid
(defn gen-block-uid
  "Generates new `:block/uid`."
  []
  #?(:cljs (subs (str (random-uuid)) 27)))



; (comment)
