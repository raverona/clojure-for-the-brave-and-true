(ns clojure-for-the-brave-and-true.chapter4.exercise2)

(defn append-suspects
  [old-suspects new-suspects]
  (->> new-suspects
       (map #(str "\n" (:name %) "," (:glitter-index %)))
       (reduce #(str %1 %2))
       (str old-suspects)))