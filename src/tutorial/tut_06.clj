(ns tutorial.tut-06
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :movie/cast => MANY REFERENCE


(def db (d/db conn))

;; Find set...

(d/q '[:find XXX
       :where
       [?m :movie/title "Pulp Fiction"]
       [?m :movie/cast ?p]
       [?p :person/name ?name]]
     db)


;; Find one...

(d/q '[:find XXX
       :where
       [?m :movie/title "Pulp Fiction"]
       [?m :movie/cast ?p]
       [?p :person/name ?name]]
     db)


;; Find list...

(d/q '[:find XXX
       :where
       [?m :movie/title "Pulp Fiction"]
       [?m :movie/cast ?p]
       [?p :person/name ?name]]
     db)
