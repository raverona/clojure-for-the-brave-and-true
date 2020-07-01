(ns clojure-for-the-brave-and-true.chapter5.exercise1-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter5.exercise1 :as chapter5.exercise1]))


(deftest test-attr
  (testing "attr should return 10 for attribute intelligence"
    (is (= 10
           (chapter5.exercise1/attr :intelligence))))

  (testing "attr should return 4 for attribute strength"
    (is (= 4
           (chapter5.exercise1/attr :strength))))

  (testing "attr should return 5 for attribute dexterity"
    (is (= 5
           (chapter5.exercise1/attr :dexterity)))))