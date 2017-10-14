(ns tutorial.tut-08
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :movie/rating => :float
;;
;; SORTING / FILTERING / etc.


(def db (d/db conn))

;; Sort by rating...

(d/q '[:find ?rating ?m ?title
       :where
       XXX]
  db)

