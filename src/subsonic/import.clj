(ns subsonic.import
  (:require [clojure-csv.core :as csv]
            [semantic-csv.core :as semantic]
            [clojure.java.io :as io]
            [clojure.data.json :as json]
            [clojure.string :as str]))

(defn parse-array [string]
  (as-> string $
    (str/replace $ #"\[" "")
    (str/replace $ #"\]" "")
    (str/replace $ #"'" "")
    (str/split $ #", ")))


(defn parse-movie [movie]
  (let [actors (parse-array (:actors movie))
        director (first (parse-array (:directors movie)))
        writers (parse-array (:writers movie))
        movie-tx {:movie/title (:title movie)
                  :movie/imdbid (:imdb_id movie)
                  :movie/rating (Float/parseFloat (:rating movie))
                  :movie/director [:person/name director]
                  :movie/cast (mapv (partial vector :person/name) actors)
                  :movie/writers (mapv (partial vector :person/name) writers)
                  :movie/budget (-> (:budget movie)
                                    (str/replace #"[^\d]" "")
                                    Integer/parseInt)}]
    movie-tx))


(defn movie-data []
  (with-open [in-file (io/reader (io/resource "movies.csv"))]
    (->>
     (csv/parse-csv in-file)
     (semantic/remove-comments)
     (semantic/mappify)
     (mapv parse-movie))))


(defn import-data []
  (let [movies (movie-data)
        people (-> (flatten [(map :movie/director movies)
                             (map :movie/writers movies)
                             (map :movie/cast movies)])
                   (set)
                   (disj :person/name))
        people (mapv (partial hash-map :person/name) people)]
    [people movies]))
