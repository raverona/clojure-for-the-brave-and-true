(ns clojure-for-the-brave-and-true.chapter4.exercise1)

(defn glitter-filter
  [minimum-glitter records]
  (->> records
       (filter #(>= (:glitter-index %) minimum-glitter))
       (map :name)))