(ns clojure-for-the-brave-and-true.chapter4.exercise1-test
  (:require [clojure.test :refer :all]
            [clojure-for-the-brave-and-true.chapter4.exercise1 :as chapter4.exercise1]))

(def file "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6")

(def vampires '("Edward Cullen", "Jacob Black", "Carlisle Cullen"))

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer/parseInt str))

(def conversions {:name identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(deftest test-glitter-filter
         (testing "glitter-filter should return the names of people with glitter-index equals or higher than"
                  (is (= vampires
                         (chapter4.exercise1/glitter-filter 3 (mapify (parse file)))))))
