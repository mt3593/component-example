(ns component-example.handler
  (:require [com.stuartsierra.component :as component]
            [ring.adapter.jetty :as jetty]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defrecord App [config]
  component/Lifecycle

  (start [this]
    (defroutes app-routes
      (GET "/ping" [] "pong")
      (route/not-found "Not Found"))

    (-> app-routes
        (wrap-defaults (update-in site-defaults [:security :anti-forgery] (fn [_] false)))))

  (stop [this]))
