(ns subsonic.schema
  (:require [datomic.api :as d]
            [datofu.schema.dsl :as dsl]
            [datofu.all]
            [subsonic.import :as import]))


(defn app-schema []
  [(dsl/attr :person/name :string :identity)

   (dsl/attr :movie/title :string :fulltext)
   (dsl/attr :movie/imdbid :string :identity)
   (dsl/attr :movie/rating :float :index)
   (dsl/attr :movie/budget :long :index)

   (dsl/to-one :movie/director)
   (dsl/to-many :movie/cast)
   (dsl/to-many :movie/writers)])


(defn schema-tx []
  (reduce into [] [(datofu.all/schema-tx) (app-schema)]))


(defn initial-data []
  (import/import-data))
