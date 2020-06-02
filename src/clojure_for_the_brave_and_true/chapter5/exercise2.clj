(ns clojure-for-the-brave-and-true.chapter5.exercise2)

(defn my-comp
  ([] identity)
  ([f] f)
  ([f & fs]
   (fn
     [& args]
     (f (apply (apply my-comp fs) args)))))
