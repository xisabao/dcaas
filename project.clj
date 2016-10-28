(defproject dcaas "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-git-deps "0.0.1-SNAPSHOT"]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [proto-repl "0.3.1"]
                 [org.mariadb.jdbc/mariadb-java-client "1.1.7"]
                 [com.mchange/c3p0 "0.9.5.2"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [crypto-random "1.2.0"]
                 [crypto-equality "1.0.0"]
                 [commons-codec "1.10"]
                 [org.clojure/core.match "0.3.0-alpha4"]
                 [org.clojure/data.json "0.2.6"]]
  :git-dependencies [["https://github.com/jakespringer/Korma.git"]]
  :source-paths [".lein-git-deps/Korma/src"
                 "src/main/clojure"]
  :java-source-paths ["src/main/java"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resource"])
