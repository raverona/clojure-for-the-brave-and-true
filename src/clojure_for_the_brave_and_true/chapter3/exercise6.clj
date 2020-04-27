(ns clojure-for-the-brave-and-true.chapter3.exercise6)

(defn- generate-body-part
  [body-part symmetry]
  {:name (str (+ symmetry 1) "-" (:name body-part))
   :size (:size body-part)})

(defn- matching-parts
  [body-part number-of-matching-parts]
  (if (= number-of-matching-parts 1)
    (list body-part)
    (map (partial generate-body-part body-part) (range number-of-matching-parts))))

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts number-of-matching-parts-to-add]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts     []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (apply vector (matching-parts part number-of-matching-parts-to-add))))))))