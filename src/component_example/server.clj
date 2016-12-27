(ns component-example.server
  (:require [com.stuartsierra.component :as component]
            [ring.adapter.jetty :as jetty]))

(defrecord Jetty [port app]
  component/Lifecycle

  (start [component]
    (assoc component :jetty (jetty/run-jetty app {:port port :join? false})))

  (stop [component]
    (.stop (:jetty component))
    (dissoc :jetty)))
