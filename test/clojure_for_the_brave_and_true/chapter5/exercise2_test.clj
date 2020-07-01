(ns clojure-for-the-brave-and-true.chapter5.exercise2-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter5.exercise2 :as chapter5.exercise2]))

(def f1 #(* % 2))
(def f2 inc)
(def f3 #(/ % 2))
(def f4 dec)
(def f5 #(- % 2))

(deftest test-my-comp
  (testing "composition of nothing should be identity"
    (is (= ((comp) 1)
           ((chapter5.exercise2/my-comp) 1))))

  (testing "composition of f1 should be f1 itself"
    (is (= ((comp f1) 1)
           ((chapter5.exercise2/my-comp f1) 1))))

  (testing "composition of f1 and f2 should be f1(f2(x))"
    (is (= ((comp f1 f2) 1)
           ((chapter5.exercise2/my-comp f1 f2) 1))))

  (testing "composition of f1, f2 and f3 should be f1(f2(f3(x)))"
    (is (= ((comp f1 f2 f3) 4)
           ((chapter5.exercise2/my-comp f1 f2 f3) 4))))

  (testing "composition of f1, f2, f3 and f4 should be f1(f2(f3(f4(x))))"
    (is (= ((comp f1 f2 f3 f4) 7)
           ((chapter5.exercise2/my-comp f1 f2 f3 f4) 7))))

  (testing "composition of f1, f2, f3, f4 and f5 should be f1(f2(f3(f4(f5(x)))))"
    (is (= ((comp f1 f2 f3 f4 f5) 17)
           ((chapter5.exercise2/my-comp f1 f2 f3 f4 f5) 17)))))