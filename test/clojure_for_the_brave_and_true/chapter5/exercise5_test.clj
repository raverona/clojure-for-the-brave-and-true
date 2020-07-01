(ns clojure-for-the-brave-and-true.chapter5.exercise5-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter5.exercise5 :as chapter5.exercise5]))

(deftest test-update-in
  (testing "should update the value of a key inside a map"
    (is (= (update-in {:key 1} [:key] inc)
           (chapter5.exercise5/my-update-in {:key 1} [:key] inc))))

  (testing "should update the value of a key inside a map with a function that takes more than one argument"
    (is (= (update-in {:key 1} [:key] + 9)
           (chapter5.exercise5/my-update-in {:key 1} [:key] + 9))))

  (testing "should update the value of a nested key inside a map"
    (is (= (update-in {:some-key {:other-key 17}} [:some-key :other-key] #(mod % 10))
           (chapter5.exercise5/my-update-in {:some-key {:other-key 17}} [:some-key :other-key] #(mod % 10)))))

  (testing "should update the value of a key inside a map, inside a vector, inside a map, inside a vector"
    (is (= (update-in [{:some-key "value"} {:other-key [{:another-key [1 2 3]} "other-value"]}] [1 :other-key 0 :another-key] (partial map #(* % 2)))
           (chapter5.exercise5/my-update-in [{:some-key "value"} {:other-key [{:another-key [1 2 3]} "other-value"]}] [1 :other-key 0 :another-key] (partial map #(* % 2)))))))