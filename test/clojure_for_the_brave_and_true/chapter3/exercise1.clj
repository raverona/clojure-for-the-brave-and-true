(ns clojure-for-the-brave-and-true.chapter3.exercise1
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.core :refer :all]))

(deftest testing-built-in-functions
  (testing "the str function"
    (is (= "the str function appends two strings together"
           (str "the str function " "appends two strings together")))
    (is (= "it works appending a string to a number: 9"
           (str "it works appending a string to a number: " 9)))
    (is (= "if nil is one of the arguments it is ignored"
           (str "if nil is one of the arguments it is ignored" nil)))
    (is (= "it can be used with vectors/lists to translate it to a string: [1 2 3]"
           (str "it can be used with vectors/lists to translate it to a string: " [1 2 3])))
    (is (= "as well as sets: #{1 3 2}"
           (str "as well as sets: " #{1 2 3})))
    (is (= "and maps: {:some-key {:some-nested-key \"some value\"}}"
           (str "and maps: " {:some-key {:some-nested-key "some value"}})))
    (is (= "why not ranges too? (0 1 2 3 4 5 6 7 8 9)"
         (str "why not ranges too? " (range 10)))))

  (testing "the vector function"
    (is (= [1 2 3]
           (vector 1 2 3)))
    (is (= [0 1 2 3 4 5 6 7 8 9]
           (apply vector (range 10))))
    (let [anon-fn #(* % 10)]
      (is (= [anon-fn map reduce]
             (vector anon-fn map reduce)))))

  (testing "the list function"
    (is (= '(1 2 3)
           (list 1 2 3)))
    (is (= '(0 1 2 3 4 5 6 7 8 9)
           (apply list (range 10))))
    (let [anon-fn #(* % 10)]
      (is (= `(~anon-fn ~map ~reduce)
              (list anon-fn map reduce)))))

  (testing "the hash-map function"
    (is (= {:some-key "some-value" :another-key "another-value"}
         (hash-map :some-key "some-value" :another-key "another-value")))
    (is (= {:vector-key [1 2 3] :function-key map :nested-map-key {}}
         (hash-map :vector-key [1 2 3] :function-key map :nested-map-key {})))
    (is (= {0 1 2 3 4 5 6 7 8 9}
         (apply hash-map (range 10))))
    (is (= {map reduce}
         (hash-map map reduce))))

  (testing "the hash-set function"
    (is (= #{1 2 3}
         (hash-set 1 2 3)))
    (is (= #{1 2 3}
         (hash-set 1 2 3 3)))
    (is (= #{0 1 2 3 4 5 6 7 8 9}
         (apply hash-set (range 10))))
    (let [anon-fn #(* % 10)]
    (is (= #{anon-fn map reduce}
         (hash-set anon-fn map reduce))))))