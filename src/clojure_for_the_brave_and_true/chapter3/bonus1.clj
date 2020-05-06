(ns clojure-for-the-brave-and-true.chapter3.bonus1)

; TODO: implement `expand-body-parts`, a function that works like `symmetrize-body-parts`,
; but takes an expander function that tells you how to expand the body parts for different creatures

(defn expand-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts expander-fn]
  (reduce (fn
            [symmetric-body-parts body-part]
            (into symmetric-body-parts
                  (expander-fn body-part)))
          []
          asym-body-parts))