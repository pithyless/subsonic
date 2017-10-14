(ns tutorial.tut-05
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :movie/writers => MANY REFERENCE
;;
;; EXAMPLE
;; [88 :person/name "Roger Avary"]
;; [99 :person/name "Quentin Tarantino"]
;; [111 :movie/title "Pulp Fiction"]
;; [111 :movie/writers 88]
;; [111 :movie/writers 99]


(def db (d/db conn))

;; Find writers...

(d/q '[:find ?name
       :where
       [?m :movie/title "Pulp Fiction"]
       XXX]
     db)
