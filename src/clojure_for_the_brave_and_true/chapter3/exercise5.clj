(ns clojure-for-the-brave-and-true.chapter3.exercise5)

(def ^:private alien-symmetry-parts #{"top", "right", "bottom-left", "bottom-right"})

(defn- generate-body-part
  [body-part symmetry]
  {:name (clojure.string/replace (:name body-part) #"^left-" (str symmetry "-"))
   :size (:size body-part)})

(defn- matching-parts
  [body-part]
  (if (re-find #"^left-" (:name body-part))
    (map (partial generate-body-part body-part) alien-symmetry-parts)
    (list body-part)))

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts     []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set (apply vector part (matching-parts part)))))))))