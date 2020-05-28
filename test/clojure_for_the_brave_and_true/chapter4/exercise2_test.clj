(ns clojure-for-the-brave-and-true.chapter4.exercise2_test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter4.exercise2 :as chapter4.exercise2]))

(def file-content "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6")

(def new-suspects '({:name "Deacon Frost" :glitter-index 5}
                    {:name "Nyssa Damaskinos" :glitter-index 3}
                    {:name "Abraham Whistler" :glitter-index 1}))

(def file-content-with-new-suspects-appended "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6\nDeacon Frost,5\nNyssa Damaskinos,3\nAbraham Whistler,1")

(deftest test-append
  (testing "append should write to the end of suspects list"
    (is (= file-content-with-new-suspects-appended
           (chapter4.exercise2/append-suspects file-content new-suspects)))))
