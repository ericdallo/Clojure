(ns webjure.entities
  (:use korma.core
        webjure.db))

(declare users lists)

(defentity users
  (pk :id)
  (table :users)
  (has-many lists)
  (entity-fields :name :email))
  
(defentity lists
  (pk :id)
  (table :lists)
  (belongs-to users {:fk :user_id})
  (entity-fields :title))
