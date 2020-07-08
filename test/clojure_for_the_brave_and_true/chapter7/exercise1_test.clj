(ns clojure-for-the-brave-and-true.chapter7.exercise1-test
  (:require [clojure.test :refer :all]))


(deftest test-clojure-reader
  (testing "forms to be evaluated can be created with quoting and the read-string function"
    (is (= (read-string "(print \"I'm Rafael and I like Star Wars\")")
           (list 'print "I'm Rafael and I like Star Wars")
           '(print "I'm Rafael and I like Star Wars")))))
