(defproject webjure "0.1.0-SNAPSHOT"
  :description "Web project with clojure"
  :url "https://github.com/ericdallo/Clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [korma "0.4.2"]
                 [mysql/mysql-connector-java "5.1.25"]
                 [migratus "0.8.13"]
                 [cheshire "5.5.0"]
                 [hiccup "1.0.5"]
                ]

  :plugins [[lein-ring "0.9.7"]
            [migratus-lein "0.1.7"]]

  :ring {:handler webjure.server/app
         :nrepl {:start? true
                 :port 9998}}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}}
  :migratus {:store :database
             :migration-dir "migrations"
             :db {:classname "com.mysql.jdbc.Driver"
                  :subprotocol "mysql"
                  :subname "//localhost/webjure"
                  :user "root"
                  :password ""}}
                                                                                          
)
