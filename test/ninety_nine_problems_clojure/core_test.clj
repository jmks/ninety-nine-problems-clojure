(ns ninety-nine-problems-clojure.core-test
  (:require [clojure.test :refer :all]
            [ninety-nine-problems-clojure.core :refer :all]))

(deftest my-last-test
  (is (= (my-last '(1 2 3)) 3) "a simple list")
  (is (= (my-last '()) nil) "an empty list"))

(deftest my-last-test
  (is (= (penultimate '()) nil) "an empty list")
  (is (= (penultimate '(1)) nil) "list too short")
  (is (= (penultimate '(1 2)) 1) "shortest list")
  (is (= (penultimate '(1 2 3)) 2) "simple list"))
