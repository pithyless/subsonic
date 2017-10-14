(ns tutorial.tut-13
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))


;; PULL API


(def db (d/db conn))


(d/q '[:find (pull ?m XXX)
       :in $ ?title
       :where
       [?m :movie/title ?title]]
     db "Pulp Fiction")

