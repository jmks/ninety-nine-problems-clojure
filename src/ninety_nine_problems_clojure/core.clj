(ns ninety-nine-problems-clojure.core)

(defn my-last
  "P01 - Find the last element of a list."
  [coll]
  (last coll))

(defn penultimate
  "P02 - Find the last but one element of a list."
  [coll]
  (last (butlast coll)))
