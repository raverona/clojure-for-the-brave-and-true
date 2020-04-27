(ns clojure-for-the-brave-and-true.chapter3.exercise6-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter3.exercise6 :as chapter3.exercise6]))

(def asym-body-parts [{:name "head" :size 3}
                      {:name "eye" :size 1}
                      {:name "ear" :size 1}
                      {:name "mouth" :size 1}
                      {:name "nose" :size 1}
                      {:name "neck" :size 2}
                      {:name "chest" :size 10}
                      {:name "back" :size 10}
                      {:name "abdomen" :size 6}
                      {:name "hand" :size 2}
                      {:name "lower-leg" :size 3}
                      {:name "foot" :size 2}])

(def two-sym-body-parts [{:name "1-head" :size 3}
                         {:name "2-head" :size 3}
                         {:name "1-eye" :size 1}
                         {:name "2-eye" :size 1}
                         {:name "1-ear" :size 1}
                         {:name "2-ear" :size 1}
                         {:name "1-mouth" :size 1}
                         {:name "2-mouth" :size 1}
                         {:name "1-nose" :size 1}
                         {:name "2-nose" :size 1}
                         {:name "1-neck" :size 2}
                         {:name "2-neck" :size 2}
                         {:name "1-chest" :size 10}
                         {:name "2-chest" :size 10}
                         {:name "1-back" :size 10}
                         {:name "2-back" :size 10}
                         {:name "1-abdomen" :size 6}
                         {:name "2-abdomen" :size 6}
                         {:name "1-hand" :size 2}
                         {:name "2-hand" :size 2}
                         {:name "1-lower-leg" :size 3}
                         {:name "2-lower-leg" :size 3}
                         {:name "1-foot" :size 2}
                         {:name "2-foot" :size 2}])

(deftest test-general-body-parts-symmetrizer
  (testing "symmetrizing body parts 0, 1 and 2 times"
    (is (= []
           (chapter3.exercise6/symmetrize-body-parts asym-body-parts 0)))

    (is (= asym-body-parts
           (chapter3.exercise6/symmetrize-body-parts asym-body-parts 1)))

    (is (= two-sym-body-parts
           (chapter3.exercise6/symmetrize-body-parts asym-body-parts 2)))))