(ns clojure-for-the-brave-and-true.chapter4.exercise3)

(defn validate
  [validation-map record]
  (loop [remaining-validations validation-map]
    (if (empty? remaining-validations)
      true
      (let [[curr & rest] remaining-validations
            validation-key  (get curr 0)
            validation-fn   (get curr 1)]
        (if (validation-fn (get record validation-key))
          (recur (rest remaining-validations))
          false)))))