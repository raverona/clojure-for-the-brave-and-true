(ns clojure-for-the-brave-and-true.chapter3.exercise3-test
  (:require [clojure-for-the-brave-and-true.chapter3.exercise3 :as chapter3.exercise3]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

(defspec testing-dec-maker
         100
         (prop/for-all [number gen/large-integer
                        decrease-factor gen/large-integer]
                       (let [dec-fn (chapter3.exercise3/dec-maker decrease-factor)]
                         (= (- number decrease-factor)
                            (dec-fn number)))))