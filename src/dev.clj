(ns dev
  (:require [clojure.core.async :as async]
            [clojure.pprint :refer [pprint]]
            [clojure.tools.namespace.repl :as tn]
            [datomic.api :as d]
            [mount.core :as mount :refer [defstate]]
            [subsonic.db :as db]))


(defn start []
  (mount/start)
  :ready)


(defn stop []
  (mount/stop)
  :stopped)


(defn reset []
  (stop)
  (tn/refresh :after 'dev/start))


(def implicit-starts
  [db/conn])


(mount/in-clj-mode)


(reset)


(comment

  (start)

  (reset)

  (stop))

  
