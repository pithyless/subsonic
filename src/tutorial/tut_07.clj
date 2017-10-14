(ns tutorial.tut-07
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :db/ident => ENUM


(def db (d/db conn))

;; Find all movie attributes...

(d/q '[:find ?attr
       :where
       [?m :movie/title _]
       XXX]
     db)
