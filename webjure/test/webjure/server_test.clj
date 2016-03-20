(ns webjure.server-test
  (:use clojure.test
        ring.mock.request
        webjure.server))

(defn is_200
  [response]
  (= (:status response) 200))

(deftest test-app
  (testing "users endpoint"
    (let [response (app (request :get "/users"))]
      (is (is_200 response))
      (is (= (get-in response [:headers "Content-Type"]) "application-json" ))))
  
  (testing "lists endpoint"
    (let [response (app (request :get "/lists"))]
      (is (is_200 response))
      (is (= (get-in response [:headers "Content-Type"]) "application-json" ))))

  (testing "not-found route"
    (let [response (app (request :get "/not-found-route"))]
      (is (= (:status response) 404)))))
