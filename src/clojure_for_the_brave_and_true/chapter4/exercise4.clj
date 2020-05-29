(ns clojure-for-the-brave-and-true.chapter4.exercise4)

(defn convert-to-csv
  [csv-content new-content]
  (->> new-content
       (map #(str "\n" (:name %) "," (:glitter-index %)))
       (reduce #(str %1 %2))
       (str csv-content)))