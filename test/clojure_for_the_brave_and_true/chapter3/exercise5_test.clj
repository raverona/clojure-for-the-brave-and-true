(ns clojure-for-the-brave-and-true.chapter3.exercise5-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter3.exercise5 :as chapter3.exercise5]))

(def asym-weird-space-aliens-body-parts [{:name "head" :size 3}
                                         {:name "left-eye" :size 1}
                                         {:name "left-ear" :size 1}
                                         {:name "mouth" :size 1}
                                         {:name "nose" :size 1}
                                         {:name "neck" :size 2}
                                         {:name "left-shoulder" :size 3}
                                         {:name "left-upper-arm" :size 3}
                                         {:name "chest" :size 10}
                                         {:name "back" :size 10}
                                         {:name "left-forearm" :size 3}
                                         {:name "abdomen" :size 6}
                                         {:name "left-kidney" :size 1}
                                         {:name "left-hand" :size 2}
                                         {:name "left-knee" :size 2}
                                         {:name "left-thigh" :size 4}
                                         {:name "left-lower-leg" :size 3}
                                         {:name "left-achilles" :size 1}
                                         {:name "left-foot" :size 2}])

(def sym-weird-space-aliens-body-parts [{:name "head" :size 3}
                                        {:name "left-eye" :size 1}
                                        {:name "right-eye" :size 1}
                                        {:name "top-eye" :size 1}
                                        {:name "bottom-left-eye" :size 1}
                                        {:name "bottom-right-eye" :size 1}
                                        {:name "left-ear" :size 1}
                                        {:name "right-ear" :size 1}
                                        {:name "top-ear" :size 1}
                                        {:name "bottom-left-ear" :size 1}
                                        {:name "bottom-right-ear" :size 1}
                                        {:name "mouth" :size 1}
                                        {:name "nose" :size 1}
                                        {:name "neck" :size 2}
                                        {:name "left-shoulder" :size 3}
                                        {:name "right-shoulder" :size 3}
                                        {:name "top-shoulder" :size 3}
                                        {:name "bottom-left-shoulder" :size 3}
                                        {:name "bottom-right-shoulder" :size 3}
                                        {:name "left-upper-arm" :size 3}
                                        {:name "right-upper-arm" :size 3}
                                        {:name "top-upper-arm" :size 3}
                                        {:name "bottom-left-upper-arm" :size 3}
                                        {:name "bottom-right-upper-arm" :size 3}
                                        {:name "chest" :size 10}
                                        {:name "back" :size 10}
                                        {:name "left-forearm" :size 3}
                                        {:name "right-forearm" :size 3}
                                        {:name "top-forearm" :size 3}
                                        {:name "bottom-left-forearm" :size 3}
                                        {:name "bottom-right-forearm" :size 3}
                                        {:name "abdomen" :size 6}
                                        {:name "left-kidney" :size 1}
                                        {:name "right-kidney" :size 1}
                                        {:name "top-kidney" :size 1}
                                        {:name "bottom-left-kidney" :size 1}
                                        {:name "bottom-right-kidney" :size 1}
                                        {:name "left-hand" :size 2}
                                        {:name "right-hand" :size 2}
                                        {:name "top-hand" :size 2}
                                        {:name "bottom-left-hand" :size 2}
                                        {:name "bottom-right-hand" :size 2}
                                        {:name "left-knee" :size 2}
                                        {:name "right-knee" :size 2}
                                        {:name "top-knee" :size 2}
                                        {:name "bottom-left-knee" :size 2}
                                        {:name "bottom-right-knee" :size 2}
                                        {:name "left-thigh" :size 4}
                                        {:name "right-thigh" :size 4}
                                        {:name "top-thigh" :size 4}
                                        {:name "bottom-left-thigh" :size 4}
                                        {:name "bottom-right-thigh" :size 4}
                                        {:name "left-lower-leg" :size 3}
                                        {:name "right-lower-leg" :size 3}
                                        {:name "top-lower-leg" :size 3}
                                        {:name "bottom-left-lower-leg" :size 3}
                                        {:name "bottom-right-lower-leg" :size 3}
                                        {:name "left-achilles" :size 1}
                                        {:name "right-achilles" :size 1}
                                        {:name "top-achilles" :size 1}
                                        {:name "bottom-left-achilles" :size 1}
                                        {:name "bottom-right-achilles" :size 1}
                                        {:name "left-foot" :size 2}
                                        {:name "right-foot" :size 2}
                                        {:name "top-foot" :size 2}
                                        {:name "bottom-left-foot" :size 2}
                                        {:name "bottom-right-foot" :size 2}])

(deftest test-weird-space-aliens-body-parts-symmetrizer
  (testing "symmetrizing weird aliens with radial symmetry of order 5"
    (is (= (set sym-weird-space-aliens-body-parts)
           (set (chapter3.exercise5/symmetrize-body-parts asym-weird-space-aliens-body-parts))))))