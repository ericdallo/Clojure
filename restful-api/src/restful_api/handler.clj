(ns restful-api.handler
    (:use compojure.core)
    (:require [compojure.handler :as handler])
)

(defn- str-to [num]
    (apply str (interpose ", " (range 1 (inc num))))
)

(defn- str-from [num]
    (apply str (interpose ", " (reverse (range 1 (inc num)))))
)

(defroutes app-routes
  (route/not-found "{'message': 'Page not found'}")
)

(def app app-routes)