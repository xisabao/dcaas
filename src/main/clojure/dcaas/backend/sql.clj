(ns dcaas.backend.sql
  (:require [clojure.string :as str]
            [clojure.core.match :refer [match]])
  (:use [korma.core]
        [korma.db]))

(defn connect-mariadb!
  [settings]
  (defdb mariadb-database
    (mariadb settings)))

(defn- parse-table-decl
  [name data]
  (str
    "CREATE TABLE " (str/upper-case name)
    "("
    (str/join ","
      (map #(str/join " "
        (map str/upper-case %)) data))
    ");"))

(defn create-table!
  [name data]
  (exec-raw
    (parse-table-decl name data)))

(defn create-users-table!
  []
  (create-table! "USERS"
     ; unique ID in the form of a username
    [["ID" "VARCHAR(127)"]

     ; hash of password + SALT_ALPHA
     ["PASSWORD_HASH" "VARCHAR(255)"]

     ; the two salts used for security and
     ; anonyminity; they have experimentally
     ; shown to not be longer than 88 chars
     ["SALT_ALPHA" "VARCHAR(90)"]
     ["SALT_BETA" "VARCHAR(90)"]]))
