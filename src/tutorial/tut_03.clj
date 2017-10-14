(ns tutorial.tut-03
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :movie/rating => :float
;;
;; EXAMPLE
;; [111 :movie/title "Pulp Fiction"]
;; [111 :movie/rating 9.0]


(def db (d/db conn))

;; Find rating...

(d/q '[:find ?rating
        :where
        [?m :movie/title "Pulp Fiction"]
        XXX]
      db)
