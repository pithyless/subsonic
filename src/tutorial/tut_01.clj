(ns tutorial.tut-01)


42


"strings"


:keyword


'symbol


:namespaced/keyword


[1 2 3]


'(1 2 3)


{:name "Norbert"
 :twitter "@pithyless"
 :language :clojure}


#{:tea :clojure :travel}


(+ 1 2 3)


(map str (filter odd? (range 8)))


(->> (range 8)
     (filter odd?)
     (map str))


(:language {:name "Norbert" :language :clojure})


'[:find ?foo
  :where
  [?bar ?baz ?qux]]


