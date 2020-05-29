(ns clojure-for-the-brave-and-true.chapter4.exercise4_test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter4.exercise4 :as chapter4.exercise4]))

(def csv-content "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6")

(def new-content '({:name "Deacon Frost" :glitter-index 5}
                    {:name "Nyssa Damaskinos" :glitter-index 3}
                    {:name "Abraham Whistler" :glitter-index 1}))

(def csv-with-new-content-appended "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6\nDeacon Frost,5\nNyssa Damaskinos,3\nAbraham Whistler,1")


(deftest test-convert-to-csv
  (testing "map content should be appended in csv format"
    (is (= csv-with-new-content-appended
           (chapter4.exercise4/convert-to-csv csv-content new-content)))))
