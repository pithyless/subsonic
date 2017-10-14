(ns tutorial.tut-10
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))

;; SCHEMA
;; :movie/title => :string :fulltext
;;
;; FULLTEXT SEARCH


(def db (d/db conn))


;; Search (via param)...

(->>
 (d/q '[:find ?score ?title
        :where [(fulltext $ :movie/title XXX)
                [[?entity ?title ?tx ?score]]]]
       db)
 (sort)
 (reverse))
