(ns ninety-nine-problems-clojure.core)

(defn my-last
  "P01 - Find the last element of a list."
  [coll]
  (if (empty? coll)
    nil
    (reduce (fn [_ x] x) coll)))

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

(defn my-flatten
  "P07 - Flatten a nested list structure."
  [coll]
  (reduce (fn [acc el]
            (if (coll? el)
              (concat acc (my-flatten el))
              (concat acc (list el))))
          '()
          coll))

(defn compress
  "P08 - Eliminate consecutive duplicates of list elements."
  [coll]
  (reverse (reduce (fn [acc el]
                     (if (= (first acc) el)
                       acc
                       (conj acc el)))
                   '()
                   coll)))

(defn pack
  "P09 - Pack consecutive duplicates of list elements into sublists. If a list contains repeated elements they should be placed in separate sublists."
  [coll]
  (reverse (reduce (fn [acc el]
                     (if (and (= (first (first acc)) el))
                       (conj (rest acc) (conj (first acc) el))
                       (conj acc (list el))))
                   '()
                   coll)))

(defn run-length-encode
  "P10 - Run-length encoding of a list. Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as lists (N E) where N is the number of duplicates of the element E."
  [coll]
  (map (fn [ident-elements] (list (length ident-elements) (first ident-elements)))
       (pack coll)))

(defn modified-run-length-encode
  "P11 - Modified run-length encoding. Modify the result of problem 10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N E) lists."
  [coll]
  (map (fn [elements] (if (= 1 (length elements))
                        (first elements)
                        (list (length elements) (first elements))))
       (pack coll)))

(defn decode-modified-run-length
  "P12 - Decode a run-length encoded list.
  Given a run-length code list generated as specified in problem 11. Construct its uncompressed version."
  [encoded]
  (mapcat (fn [enc]
            (if (list? enc)
              (repeat (first enc) (second enc))
              (list enc)))
          encoded))

(defn run-length-direct-encode
  "P13 - Run-length encoding of a list (direct solution).

  Implement the so-called run-length encoding data compression method directly.

  i.e. don't explicitly create the sublists containing the duplicates, as in problem 9, but only count them. As in problem P11, simplify the result list by replacing the singleton lists (1 X) by X."
  [coll]
  (if (empty? coll)
    '()
    (let [el (first coll)
          els (take-while #(= % el) coll)
          els-count (length els)]
      (if (= els-count 1)
        (cons el (run-length-direct-encode (rest coll)))
        (cons (list els-count el) (run-length-direct-encode (drop-while #(= % el) coll)))))))

(defn dupli
  "P14 - Duplicate the elements of a list."
  [coll]
  (mapcat #(list % %) coll))

(defn repli
  "P15  - Replicate the elements of a list a given number of times."
  [count coll]
  (mapcat #(repeat count %) coll))

(defn drop-nth
  "P16 - Drop every N'th element from a list."
  [nth coll]
  (let [start (take (- nth 1) coll)
        end (drop nth coll)]
    (if (empty? end)
      start
      (concat start (drop-nth nth end)))))

(defn split
  "P17 -Split a list into two parts; the length of the first part is given.
   Do not use any predefined predicates."
  [n coll]
  (list (take n coll) (drop n coll)))

(defn slice
  "P18 - Extract a slice from a list.

  Given two indices, i and k, the slice is the list containing the elements between the i'th and k'th element of the original list (both limits included). Start counting the elements with 1."
  [coll start end]
  (let [start0 (- start 1)]
    (take (- end start0) (drop start0 coll))))

(defn rotate
  "P19 - Rotate a list N places to the left."
  [n coll]
  (let [rotated (if (>= n 0)
                  n
                  (+ (count coll) n))]
    (concat (drop rotated coll) (take rotated coll))))

(defn remove-kth
  "P20 - Remove the K'th element from a list."
  [k coll]
  (concat (take (- k 1) coll) (drop k coll)))

(defn insert-at
  "P21 - Insert an element at a given position into a list."
  [el n coll]
  (concat (take n coll) (conj (drop n coll) el)))
