(ns clojure-for-the-brave-and-true.chapter3.exercise2-test
  (:require [clojure-for-the-brave-and-true.chapter3.exercise2 :as chapter3.exercise2]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(defspec testing-experiment
         100
         (prop/for-all [number gen/large-integer]
                       (= (+ number 100)
                          (chapter3.exercise2/add100 number))))
