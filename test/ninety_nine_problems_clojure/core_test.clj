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

(deftest length-test
  (is (= (length '()) 0) "an empty list")
  (is (= (length '(1)) 1) "singleton list")
  (is (= (length '(1 2 3)) 3) "simple list"))

(deftest reverse-test
  (is (= (my-reverse '()) '()) "an empty list")
  (is (= (my-reverse '(1)) '(1)) "singleton list")
  (is (= (my-reverse [1 2 3]) '(3 2 1)) "simple list"))

(deftest palindrome-test
  (is (= (palindrome? '()) true) "vacuously true")
  (is (= (palindrome? [:one]) true) "singleton always true")
  (is (= (palindrome? '(1 2 3)) false) "non-palindrome")
  (is (= (palindrome? [1 2 1]) true) "palindrome"))

(deftest flatten-test
  (is (= (my-flatten '(1 2 3)) '(1 2 3)) "no flattening")
  (is (= (my-flatten ['(1 2) 3 [4 5]]) '(1 2 3 4 5)) "simple flattening")
  (is (= (my-flatten [(list 1 [2 (list 3 [4 5])])]) '(1 2 3 4 5)) "deeply nested"))

(deftest compress-test
  (is (= (compress '(1 2 3)) '(1 2 3)) "no compression")
  (is (= (compress '(1 1 2 2 2 3)) '(1 2 3)) "compression"))

(deftest pack-test
  (is (= (pack (list 1 1 1 1 2 3 3 1 1 4 5 5 5 5)) (list '(1 1 1 1) '(2) '(3 3) '(1 1) '(4) '(5 5 5 5))))
  (is (= (pack (list 1 2 3)) (list '(1) '(2) '(3))) "no packing just wraps each in list"))

(deftest run-length-encode-test
  (is (= (run-length-encode (list 1 1 1 1 2 3 3 1 1 4 5 5 5 5)) (list '(4 1) '(1 2) '(2 3) '(2 1) '(1 4) '(4 5)))))

(deftest modified-run-length-encode-test
  (is (= (modified-run-length-encode '(1 1 1 1 2 3 3 1 1 4 5 5 5 5)) (list '(4 1) 2 '(2 3) '(2 1) 4 '(4 5)))))

(deftest modified-run-length-encode-test
  (is (= (decode-modified-run-length (list '(4 1) 2 '(2 3) '(2 1) 4 '(4 5))) '(1 1 1 1 2 3 3 1 1 4 5 5 5 5))))

(deftest run-length-direct-encode-test
  (is (= (run-length-direct-encode  (list 1 1 1 1 2 3 3 1 1 4 5 5 5 5)) (list '(4 1) 2 '(2 3) '(2 1) 4 '(4 5)))))

(deftest dupli-test
  (is (= (dupli '()) '()) "duplicate of empty is empty")
  (is (= (dupli [1]) '(1 1)) "duplicate of singleton")
  (is (= (dupli (list :a :b :c)) (list :a :a :b :b :c :c)) "duplicate of simple list"))

(deftest repli-test
  (is (= (repli 0 '(1 2 3)) '()) "replicated 0 times is no elements")
  (is (= (repli 1 [1]) '(1)) "replicated once is identity")
  (is (= (repli 3 (list :a :b :c)) (list :a :a :a :b :b :b :c :c :c)) "triplicated"))
