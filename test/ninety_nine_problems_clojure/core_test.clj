(ns ninety-nine-problems-clojure.core-test
  (:require [clojure.test :refer :all]
            [ninety-nine-problems-clojure.core :refer :all]))

(deftest my-last-test
  (is (= (my-last '(1 2 3)) 3) "a simple list")
  (is (= (my-last '()) nil) "an empty list"))

(deftest penultimate-test
  (is (= (penultimate '()) nil) "an empty list")
  (is (= (penultimate '(1)) nil) "list too short")
  (is (= (penultimate '(1 2)) 1) "shortest list")
  (is (= (penultimate '(1 2 3)) 2) "simple list"))

(deftest kth-test
  (is (thrown? java.lang.IndexOutOfBoundsException (kth '() 1)) "an empty list")
  (is (thrown? java.lang.IndexOutOfBoundsException (kth '(1) 0)) "out of lower bounds")
  (is (thrown? java.lang.IndexOutOfBoundsException (kth '(1) 2)) "out of upper bounds")
  (is (= (kth '(1) 1) 1) "singleton list")
  (is (= (kth '(:one :two :three) 1) :one) "simple list")
  (is (= (kth '(:one :two :three) 2) :two) "simple list")
  (is (= (kth '(:one :two :three) 3) :three) "simple list"))
