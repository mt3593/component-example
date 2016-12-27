(ns component-example.main
  (:require [com.stuartsierra.component :as component]
            [component-example.server :refer [map->Jetty]]
            [component-example.handler :refer [map->App]])
  (:gen-class))

(defn- example-system []
  (-> (component/system-map
       :app (map->App {:config {}})
       :jetty (component/using
               (map->Jetty {:port 8080})
               [:app :app]))))

(defn -main [& args]
  (component/start-system (example-system)))
