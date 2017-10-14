(ns tutorial.tut-04
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :movie/director => REFERENCE
;; :person/name    => :string
;;
;; EXAMPLE
;; [99 :person/name "Quentin Tarantino"]
;; [111 :movie/title "Pulp Fiction"]
;; [111 :movie/director 99]


(def db (d/db conn))

;; Find director...

(d/q '[:find ?name
        :where
        [?m :movie/title "Pulp Fiction"]
        XXX]
      db)
