(ns clojure-for-the-brave-and-true.chapter3.exercise1)

(str "the str function " "appends two strings together")
(str "it works appending a string to a number: " 9)
(str "if nil is one of the arguments it is ignored" nil)
(str "it can be used with vectors/lists to translate it to a string: " [1 2 3])
(str "as well as sets: " #{1 2 3})
(str "and maps: " {:some-key {:some-nested-key "some value"}})
(str "why not ranges too? " (range 10))

(vector 1 2 3)
(apply vector (range 10))
(vector #(* % 10) map reduce)

(list 1 2 3)
(apply list (range 10))
(list #(* % 10) map reduce)

(hash-map :some-key "some-value" :another-key "another-value")
(hash-map :vector-key [1 2 3] :function-key map :nested-map-key {})
(apply hash-map (range 10))
(hash-map map reduce)

(hash-set 1 2 3)
(hash-set 1 2 3 3)
(apply hash-set (range 10))
(hash-set #(* % 10) map reduce)