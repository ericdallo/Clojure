(ns app 
  (:gen-class))
  
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
  (deref (future (Thread/sleep 5000) (123)) 3 (println "Timeout ;(")))

(defn is-finished?
  []
  (def over (future (Thread/sleep 2000) (println "End!")))
  (println (realized? over)))

(defn -main
  []
  (is-finished?)
  (shutdown-agents))

