(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.9.0-beta2"]
                  [nightlight "1.9.0" :scope "test"]

                  [org.clojure/core.async "0.3.443"]
                  [mount/mount "0.1.11"]
                  [com.taoensso/timbre "4.10.0"]
                  [cheshire "5.7.1"]
                  [metosin/spec-tools "0.3.3"]
                  [com.stuartsierra/frequencies "0.1.0"]
                  [clojure-csv/clojure-csv "2.0.1"]
                  [semantic-csv "0.2.1-alpha1"]
                  [org.clojure/data.json "0.2.6"]

                  ;; [com.datomic/datomic-pro "0.9.5561.59"]
                  [com.datomic/datomic-free "0.9.5561.59"]
                  [vvvvalvalval/datofu "0.1.0"]

                  [org.clojure/tools.namespace "0.2.11" :scope "test"]
                  [samestep/boot-refresh "0.1.0" :scope "test"]])


(require '[nightlight.boot :refer [nightlight]]
         '[samestep.boot-refresh :refer [refresh]])


(deftask dev []
  (comp
   (watch)
   (repl :server true)
   (refresh)))


(deftask run []
  (comp
    (wait)
    (nightlight :port 4000)))
