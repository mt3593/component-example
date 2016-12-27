(ns component-example.handler-test
  (:require [clojure.test :refer :all]
            [component-example.handler :refer :all]
            [ring.mock.request :as mock]
            [com.stuartsierra.component :as component]))

(defn with-app
  [request]
  (let [app (component/start (map->App {:config {}}))]
    (try
      (app request)
      (finally
        (component/stop app)))))

(deftest test-app
  (testing "ping"
    (let [response (with-app (mock/request :get "/ping"))]
      (is (= (:status response) 200))
      (is (= (:body response) "pong"))))

  (testing "not-found route"
    (let [response (with-app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
