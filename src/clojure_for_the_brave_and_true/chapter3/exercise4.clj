(ns clojure-for-the-brave-and-true.chapter3.exercise4)

(defn do-mapset
  [f coll set]
  (if (not-empty coll)
    (recur f (rest coll) (conj set (f (first coll))))
    set))

(defn mapset
  "The map function, but it returns a set.
   Obs: At this point the book only mentions the usage of the map function
        with a function and one collection, so that's the only arity implemented here."
  [f coll]
  (do-mapset f coll #{}))