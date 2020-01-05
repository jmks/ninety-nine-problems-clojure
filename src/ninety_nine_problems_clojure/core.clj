(ns ninety-nine-problems-clojure.core)

(defn my-last
  "P01 - Find the last element of a list."
  [coll]
  (last coll))

(defn penultimate
  "P02 - Find the last but one element of a list."
  [coll]
  (last (butlast coll)))

(defn kth
  "P03 - Find the K'th element of a list. The first element in the list is number 1."
  [coll k]
  (nth coll (- k 1)))

(defn length
  "P04 - Find the number of elements of a list."
  [coll]
  (reduce (fn [count _] (inc count)) 0 coll))

(defn my-reverse
  "P05 - Reverse a list."
  [coll]
  (reduce conj '() coll))

(defn palindrome?
  "P06 - Find out whether a list is a palindrome. A palindrome can be read forward or backward; e.g. (x a m a x)"
  [coll]
  (= coll (reverse coll)))
