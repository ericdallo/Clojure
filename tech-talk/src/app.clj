(ns app 
  (:gen-class)
  (:require [macro :refer :all]))
  
(defn task-future
  "Print a line before and after a future(another thread)"
  []
  (let [greg-in-future (future (Thread/sleep 3000)
          (println "Hey from future Greg!"))]
  (println "Greg from present here")
  (println @greg-in-future))
  (println "Post greg"))

(defn default-value
  "Returns a default value in future Thread timeout" 
  []
  (deref (future (Thread/sleep 5000) 123) 2000 "Timeout ;("))

(defn is-finished?
  ([]
    (def over (future (Thread/sleep 2000) (println "End!")))
    (println (realized? over)))
  ([wait-for-it]
    (def over (future (Thread/sleep 2000) (println "End!")))
    (unless wait-for-it
      (println (realized? over))
      (do
        (Thread/sleep 3000)
        (println (realized? over))))))


(defn -main
  []
  (is-finished?)
  (shutdown-agents))

