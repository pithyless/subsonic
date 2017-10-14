(ns tutorial.tut-00)


;; # DATABASES

;; ## Model
;; - hierarchical
;; - relational
;; - inverted-index
;; - document
;; - key-value


;; ## Query
;;
;; - SQL
;; - MapReduce
;; - Graph


;; ## Storage
;;
;; - Overwrite block
;; - Append to log


;; # Hackathon
;;
;; - "Pick the right tool..."
;; - "We ain't got no time for that!"


;; # DATOMIC

;; ## CQRS
;;
;; - Transactor
;; - Peers
;; - Storage
;;
;;    +------------+         +------+
;;    |            |         | Peer |
;;    | Transactor |         +------+
;;    |            |
;;    +------------+         +------+
;;                           | Peer |
;;                           +------+
;;
;;    +-------------------------------+
;;    |                               |
;;    |          Storage              |
;;    |                               |
;;    |                               |
;;    +-------------------------------+

;; ## Storage
;;
;; [e a v]
;; [e a v]
;; [e a v]
;; [e a v]


;; ## Datalog
;;
;; [:find [...]
;;  :in ...
;;  :where ...]


;; http://docs.datomic.com/query.html
;; http://docs.datomic.com/pull.html
