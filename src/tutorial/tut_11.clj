(ns tutorial.tut-11
  (:require [datomic.api :as d]
            [subsonic.db :refer [conn]]))


;; GRAPH - What other movies have actors starred in?


(def db (d/db conn))


(d/q '[:find ?actor ?m2-title
       :in $ ?m1-title
       :where
       XXX]
     db "Pulp Fiction")









;; GRAPH - The Kevin Bacon factor

(defn actor-or-movie-name [db eid]
  (let [ent (d/entity db eid)]
    (or (:movie/title ent) (:person/name ent))))


(defn acted-with-rules []
  '[[(acted-with ?e1 ?e2 ?path)
     [?m :movie/cast ?e1]
     [?m :movie/cast ?e2]
     [(!= ?e1 ?e2)]
     [(vector ?e1 ?m ?e2) ?path]]
    [(acted-with-1 ?e1 ?e2 ?path)
     (acted-with ?e1 ?e2 ?path)]
    [(acted-with-2 ?e1 ?e2 ?path)
     (acted-with ?e1 ?x ?pp)
     (acted-with ?x ?e2 ?p2)
     [(butlast ?pp) ?p1]
     [(concat ?p1 ?p2) ?path]]
    [(acted-with-any ?e1 ?e2 ?path)
     [acted-with ?e1 ?e2 ?path]]
    [(acted-with-any ?e1 ?e2 ?path)
     [acted-with-2 ?e1 ?e2 ?path]]])
    

(->> (d/q '[:find ?path
            :in $ % ?start ?end
            :where
            [?a1 :person/name ?start]
            [?a2 :person/name ?end]
            (acted-with-any ?a1 ?a2 ?path)]
       db (acted-with-rules) "Kevin Costner" "Kevin Bacon")
     (map first)
     (sort-by count)
     (map (partial mapv (partial actor-or-movie-name db)))
     first)






