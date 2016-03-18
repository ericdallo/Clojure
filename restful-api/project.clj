(defproject restful-api "0.1.0-SNAPSHOT"
    :description "Projeto API clojure"
    :url ""
    :license {:name "Eclipse Public License"
    :url "http://www.eclipse.org/legal/epl-v10.html"}
    :dependencies [
        [org.clojure/clojure "1.5.1"]
        [ring/ring-core "1.2.1"]
        [ring/ring-jetty-adapter "1.2.1"]
        [compojure "1.2.1"]
    ]
    :plugins [[lein-ring "0.8.10"]]
    :ring {
        :handler restful-api.handler/app
        :nrepl {:start? true :port 9998}
    }
    :profiles {
        :dev {:dependencies [[javax.servlet/servlet-api "2.5"] [ring-mock "0.1.5"]]}
    }
)