(ns clojure-for-the-brave-and-true.chapter4.exercise2)

(defn append-suspects
  [filename new-suspect]
  (spit filename (str "\n" (:name new-suspect) "," (:glitter-index new-suspect)) :append true))