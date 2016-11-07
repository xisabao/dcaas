(ns dcaas.backend.create
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(def config
{:datastore (jdbc/sql-database "jdbc:mysql://localhost:3306/dcaas", "root")
 :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate (load-config)))
(defn rollback []
  (repl/rollback (load-config)))