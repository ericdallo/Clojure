(ns webjure.server
  (:use compojure.core
        ring.middleware.json)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :refer [response]]))

(defn log-to-console [handler]
  (fn [req]
    (println (:body req))
    (handler req)))

(defroutes app-routes
  (context "/users" []
    (GET "/" [] 
      (-> get-users)))
  (route/not-found (response {:message "Page not found"})))

(def app 
  (-> app-routes
      log-to-console
      wrap-json-response
      wrap-json-body))
