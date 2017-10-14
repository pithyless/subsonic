(ns subsonic.db
  (:require [datomic.api :as d]
            [mount.core :as mount :refer [defstate]]
            [datofu.migration :as migration]
            [subsonic.schema :as schema]))


(def db-uri "datomic:mem://subsonic")


(defstate conn
  :start (let [txes (schema/schema-tx)
               created? (d/create-database db-uri)
               conn (d/connect db-uri)]
           (migration/install-and-migrate! conn txes [])
           (doseq [tx (schema/initial-data)]
             @(d/transact conn tx))
           conn)
  :stop (do (d/delete-database db-uri)
            nil))
