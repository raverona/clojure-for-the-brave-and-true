(ns clojure-for-the-brave-and-true.chapter4.exercise2_test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [clojure-for-the-brave-and-true.chapter4.exercise2 :as chapter4.exercise2]))

(def filename "suspects.csv")

(def file-content "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6")

(defn- create-file
  [filename file-content]
  (spit filename file-content))

(defn- delete-file
  [filename]
  (io/delete-file filename))

(def new-suspect {:name "Deacon Frost" :glitter-index 5})

(def file-content-with-new-suspect-appended "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6\nDeacon Frost,5")

(defn- test-set-up-and-tear-down
  [f]
  (create-file filename file-content)
  (f)
  (delete-file filename))

(use-fixtures :once test-set-up-and-tear-down)

(deftest test-append
  (testing "append should write to the end of suspects list"
    (chapter4.exercise2/append-suspects filename new-suspect)
    (is (= file-content-with-new-suspect-appended
           (slurp filename)))))
