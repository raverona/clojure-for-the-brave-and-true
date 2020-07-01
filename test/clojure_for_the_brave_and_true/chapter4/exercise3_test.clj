(ns clojure-for-the-brave-and-true.chapter4.exercise3-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter4.exercise3 :as chapter4.exercise3]))

(defn validate-name
  [name]
  (and (= String (type name))
       (not-empty name)))

(defn validate-glitter-index
  [glitter-index]
  (and (= Integer (type glitter-index))
       (> glitter-index 0)))

(def validation-map {:name validate-name
                     :glitter-index validate-glitter-index})

(def valid-record {:name "Eric Brooks" :glitter-index 0})

(def invalid-record {:name "Eric Brooks"})

(deftest test-validate
  (testing "validate returns true if record is valid"
    (is (= true
           (chapter4.exercise3/validate validation-map valid-record))))

  (testing "validate returns false if record is valid"
    (is (= false
         (chapter4.exercise3/validate validation-map invalid-record)))))