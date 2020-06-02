(ns clojure-for-the-brave-and-true.chapter5.exercise3_test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter5.exercise3 :as chapter5.exercise3]))

(deftest test-my-assoc-in
  (testing "associating one key to an empty map should create a key/value pair"
    (is (= (assoc-in {} [:key] "value")
           (chapter5.exercise3/my-assoc-in {} [:key] "value"))))

  (testing "associating multiple keys to an empty map should create nested key/value pairs"
    (is (= (assoc-in {} [:some-key :other-key :another-key] "value")
           (chapter5.exercise3/my-assoc-in {} [:some-key :other-key :another-key] "value"))))

  (testing "associating one key to a map with existing key/value pairs should create a new key/value pair and keep the old ones"
    (is (= (assoc-in {:some-key "some-value"} [:other-key] "other-value")
           (chapter5.exercise3/my-assoc-in {:some-key "some-value"} [:other-key] "other-value"))))

  (testing "associating multiple keys to a map with existing key/value pairs should create nested key/value pairs and keep the old ones"
    (is (= (assoc-in {:some-key "some-value"} [:other-key :another-key] "other-value")
           (chapter5.exercise3/my-assoc-in {:some-key "some-value"} [:other-key :another-key] "other-value"))))

  (testing "associating multiple keys to a map with existing key/value pairs should create nested key/value pairs and keep the old ones"
    (is (= (assoc-in {:some-key "some-value"} [:other-key :another-key] "other-value")
           (chapter5.exercise3/my-assoc-in {:some-key "some-value"} [:other-key :another-key] "other-value"))))

  (testing "associating multiple keys to a map, inside a vector, with existing key/value pairs should create nested key/value pairs inside the map in the vector and keep the old ones"
    (is (= (assoc-in [{:some-key "some-value"}] [0 :other-key :another-key] "other-value")
           (chapter5.exercise3/my-assoc-in [{:some-key "some-value"}] [0 :other-key :another-key] "other-value")))))