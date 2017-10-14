(ns tutorial.tut-12
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))


;; ENTITY + TOUCH


(def db (d/db conn))


(d/q '[:find ?m .
       :in $ ?title
       :where
       [?m :movie/title ?title]]
     db "Pulp Fiction")


(->>
 (d/q '[:find ?m .
        :in $ ?title
        :where
        [?m :movie/title ?title]]
   db "Pulp Fiction")
 XXX)
