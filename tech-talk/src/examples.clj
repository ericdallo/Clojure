(ns examples)

(defn factorial  [x]
  (if (zero? x)
    1
    (* x (factorial (dec x)))))

(defn factorialV2
  ([x] (factorialV2 1 x))
  ([acc x] 
    (if (zero? x)
      acc
      (recur (* x acc) (dec x)))))

(defn factorialV3 [x]
  (reduce * (range 1 (inc (x)))))


