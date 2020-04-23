(ns clojure-for-the-brave-and-true.chapter3.exercise3)

(defn dec-maker
  "Returns a function that subtracts a number by the factor supplied"
  [decrease-factor]
  #(- % decrease-factor))
