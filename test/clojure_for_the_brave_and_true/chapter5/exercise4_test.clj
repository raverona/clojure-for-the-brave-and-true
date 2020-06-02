(ns clojure-for-the-brave-and-true.chapter5.exercise4_test
  (:require [clojure.test :refer :all]))

(deftest test-update-in
  (testing "should update the value of a key inside a map"
    (is (= {:key 2}
           (update-in {:key 1} [:key] inc))))

  (testing "should update the value of a key inside a map with a function that takes more than one argument"
    (is (= {:key 10}
           (update-in {:key 1} [:key] + 9))))

  (testing "should update the value of a nested key inside a map"
    (is (= {:some-key {:other-key 7}}
           (update-in {:some-key {:other-key 17}} [:some-key :other-key] #(mod % 10)))))

  (testing "should update the value of a key inside a map, inside a vector, inside a map, inside a vector"
    (is (= [{:some-key "value"} {:other-key [{:another-key [2 4 6]} "other-value"]}]
           (update-in [{:some-key "value"} {:other-key [{:another-key [1 2 3]} "other-value"]}] [1 :other-key 0 :another-key] (partial map #(* % 2)))))))