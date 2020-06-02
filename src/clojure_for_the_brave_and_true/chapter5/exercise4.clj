(ns clojure-for-the-brave-and-true.chapter5.exercise4)

(update-in {:key 1} [:key] inc)
(update-in {:key 1} [:key] + 9)
(update-in {:some-key {:other-key 17}} [:some-key :other-key] #(mod % 10))
(update-in [{:some-key "value"} {:other-key [{:another-key #{1 2 3}} "other-value"]}] [1 :other-key 0 :another-key] (partial map #(* % 2)))