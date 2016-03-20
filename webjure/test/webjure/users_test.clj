(ns webjure.users-test
  (:use clojure.test
        webjure.test-core)
  (:require [webjure.models.users :as users]
            [environ.core :refer [env]]))

env; Run each test in an isolated db transaction and rollback
(use-fixtures :each with-rollback)

(deftest create-read-users
  (testing "Create user"
    (let [count-orig (users/count-users)]
      (users/create {:name "Charlie" :email "charlie@example.com"})
      (is (= (inc count-orig) (users/count-users)))))

  (testing "Retrieve user"
    (let [user (users/create {:name "Andrew" :email "me@mytest.com"})
          found-user (users/find-by-id (user :id))]
      (is (= "Andrew" (found-user :name))
      (is (= "me@mytest.com" (found-user :email))))))
)
