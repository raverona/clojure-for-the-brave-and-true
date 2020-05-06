(ns clojure-for-the-brave-and-true.chapter3.bonus1-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter3.bonus1 :as chapter3.bonus1]))

(def asym-hobbit-body-parts [{:name "head" :size 3}
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

(def sym-hobbit-body-parts [{:name "head" :size 3}
                            {:name "left-eye" :size 1}
                            {:name "right-eye" :size 1}
                            {:name "left-ear" :size 1}
                            {:name "right-ear" :size 1}
                            {:name "mouth" :size 1}
                            {:name "nose" :size 1}
                            {:name "neck" :size 2}
                            {:name "chest" :size 10}
                            {:name "back" :size 10}
                            {:name "abdomen" :size 6}
                            {:name "left-hand" :size 2}
                            {:name "right-hand" :size 2}
                            {:name "left-lower-leg" :size 3}
                            {:name "right-lower-leg" :size 3}
                            {:name "left-foot" :size 2}
                            {:name "right-foot" :size 2}])

(def ^:private expandable-hobbit-body-parts [{:name "eye" :symmetry #{"left" "right"}}
                                             {:name "ear" :symmetry #{"left" "right"}}
                                             {:name "hand" :symmetry #{"left" "right"}}
                                             {:name "lower-leg" :symmetry #{"left" "right"}}
                                             {:name "foot" :symmetry #{"left" "right"}}])

(defn- generate-symmetry
  [body-part symmetry]
  (map #(do {:name (str % "-" (:name body-part)) :size (:size body-part)}) symmetry))

(defn- hobbit-expansion-fn
  [body-part]
  (or
   (some->> expandable-hobbit-body-parts
            (some #(when (= (:name body-part) (:name %)) %))
            :symmetry
            (generate-symmetry body-part))
   (list body-part)))

(deftest test-expand-body-parts
  (testing "expanding body parts with a hobbit expansion function"
    (is (= (set sym-hobbit-body-parts)
           (set (chapter3.bonus1/expand-body-parts asym-hobbit-body-parts hobbit-expansion-fn))))))
