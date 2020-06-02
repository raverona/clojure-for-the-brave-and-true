(ns clojure-for-the-brave-and-true.chapter5.exercise3)

(defn my-assoc-in
  ([m [k & ks] v]
   (if (nil? ks)
     (assoc m k v)
     (assoc m k (my-assoc-in (get m k) ks v)))))