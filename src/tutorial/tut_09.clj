(ns tutorial.tut-09
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :movie/rating => :float
;;
;; AGGREGATIONS


(def db (d/db conn))


;; How many movies are there?

(d/q '[:find XXX
       :with XXX
       :where XXX]
       
  db)


;; What are some ratings stats?

(d/q '[:find XXX
       :with XXX
       :where XXX]
       
  db)
