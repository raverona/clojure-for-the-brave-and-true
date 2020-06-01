(ns clojure-for-the-brave-and-true.chapter5.exercise1)

(def ^:private character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(defn attr
  [attr-name]
  ((comp attr-name :attributes) character))