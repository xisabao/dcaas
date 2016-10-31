(ns dcaas.backend.create
  (:require [clojure.string :as str]
            [clojure.core.match :refer [match]])
  (:use [korma.core]
        [korma.db]))

(defn connect-mariadb!
  [settings]
  (defdb mariadb-database
    (mariadb settings)))

(declare researchers users responses surveys questions)

(defentity researchers
  (pk :id)
  (table :researchers)
  (entity-fields :username :email : password_hash :salt_alpha :salt_beta :role)
  (has-many :surveys)
)

(defentity users
  (pk :id)
  (table :users)
  (entity-fields :username :email :password_hash :salt_alpha :salt_beta :role)
  (has-many responses)
  (many-to-many surveys :users_surveys)
  ;need to figure out how to do this
  )

(defentity responses
  (pk :id)
  (table :responses)
  (entity-fields :value :submitted_date)
  (belongs-to users)
  (belongs-to questions)
  (belongs-to surveys)
)

(defentity surveys
  (pk :id)
  (table :surveys)
  (entity-fields :name :description)
  (many-to-many users :users_surveys)
  (belongs_to researchers)
  (has-many questions)
  (has-many responses)
)

(defentity questions
  (pk :id)
  (table :questions)
  (entity-fields :text :details :input_type :options)
  (belongs_to surveys)
  (has-many responses)
)

