(defproject component-example "0.1.0-SNAPSHOT"
  :description "This is the component-example system"
  :url ""
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [com.stuartsierra/component "0.3.2"]]

  :profiles {:dev {:dependencies [[ring/ring-mock "0.3.0"]]}}

  :main component-example.main
  :uberjar-name "component-example.jar")
