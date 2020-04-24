(ns clojure-for-the-brave-and-true.chapter3.exercise4-test
  (:require [clojure-for-the-brave-and-true.chapter3.exercise4 :as chapter3.exercise4]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer [defspec]]))

; A random transformation function to test the mapset function
(defn- mod-10
  "Returns the remainder of the provided number divided by 10"
  [x]
  (rem x 10))

(defspec testing-mapset
         100
         (prop/for-all [collection (gen/vector gen/large-integer)]
                       (= (into #{} (map mod-10 collection))
                          (chapter3.exercise4/mapset mod-10 collection))))