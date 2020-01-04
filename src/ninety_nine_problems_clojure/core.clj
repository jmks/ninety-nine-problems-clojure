(ns ninety-nine-problems-clojure.core)

(defn my-last
  "P01 - last element of a list"
  [coll]
  (last coll))

(defn penultimate
  "P02 - last but one element of a list"
  [coll]
  (last (butlast coll)))
