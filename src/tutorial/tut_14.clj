(ns tutorial.tut-14
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))


;; But wait, there's more!
;;
;; [e a v] => [e a v tx add?]


(def db (d/db conn))


(d/q '[:find (pull ?tx [*])
       :in $ ?title
       :where
       [?m :movie/title ?title ?tx]]
     db "Pulp Fiction")


;; FILTERS
;; as-of, since, history, filter, ...

(d/q '[:find (pull ?tx [*])
       :in $ ?title
       :where
       [?m :movie/title ?title ?tx]]
     (d/as-of db #inst "2000-01-01") "Pulp Fiction")

