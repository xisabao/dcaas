(ns dcaas.backend.authentication
  (:require [clojure.string :as str]
            [dcaas.util.base64 :as base64]
            [dcaas.util.pbkdf2 :as pbkdf2])
  (:use [korma.core]
        [korma.db])
  (:import org.apache.commons.codec.binary.Base64))

(defn- random-bytes [len]
  (byte-array len (take len (repeatedly #(rand-int 256)))))

(defn- generate-salt [len]
  (base64/base64-encode (random-bytes len)))

(defn- salt-and-hash [password salt]
  (pbkdf2/encrypt password 100000 "HMAC-SHA256" (base64/base64-decode salt)))

(defn- check-hash [real hash]
  (pbkdf2/check real hash))

(defn- new-user [{:keys [user password
                       salt-alpha salt-beta
                       salt-alpha-len salt-beta-len]
                :or {salt-alpha nil
                     salt-beta nil
                     salt-alpha-len 64
                     salt-beta-len 64}
                :as params}]
  "Creates a new user with the username, password
  and (optional) salts specified. Returns a map with
  the necessary information."
  (let [salt-alpha# (if (nil? salt-alpha)
                      (generate-salt salt-alpha-len)
                      salt-alpha)
        salt-beta# (if (nil? salt-beta)
                      (generate-salt salt-beta-len)
                      salt-beta)]
    {:user user
     :password (salt-and-hash password salt-alpha#)
     :salt-alpha salt-alpha#
     :salt-beta salt-beta#}))

(defn create-user! [{:keys [user-id password
                       salt-alpha salt-beta
                       salt-alpha-len salt-beta-len]
                :or {salt-alpha nil
                     salt-beta nil
                     salt-alpha-len 64
                     salt-beta-len 64}
                :as params}])

(defn update-user! [user-id])

(defn get-password-hash [user-id])


(defn correct-password? [user-id password-guess]
  )
