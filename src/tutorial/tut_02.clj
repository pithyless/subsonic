(ns tutorial.tut-02
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :movie/title => :string
;;
;; EXAMPLE
;; [111 :movie/title "Pulp Fiction"]


(def db (d/db conn))


;; Find id...

(d/q '[:find ?m
        :where XXX
        [?m :movie/title XXX]]
      db)

;; Find title...

(d/q '[:find ?title
        :where
        [XXX :movie/title ?title]]
      db)

;; Find all id + title...

(d/q '[:find ?m ?title
        :where
        XXX]
      db)
