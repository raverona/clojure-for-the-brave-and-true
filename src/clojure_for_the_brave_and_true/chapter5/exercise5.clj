(ns clojure-for-the-brave-and-true.chapter5.exercise5)

(defn my-update-in
  [m ks f & args]
  (if (= 1 (count ks))
    (apply update (cons m (cons (nth ks 0) (cons f args))))
    (update m (first ks) #(apply my-update-in (cons % (cons (rest ks) (cons f args)))))))
