(ns macro (:gen-class))

(defmacro unless
  "Inverted if"
  [bool & other]
  (conj (reverse other) bool 'if))

(defmacro infix
  "infix notation"
  [infixed]
  (list (second infixed) (first infixed) (last infixed)))
