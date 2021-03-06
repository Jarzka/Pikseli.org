(ns pikseli.core
  (:require [compojure.core :refer [defroutes GET POST DELETE ANY context]]
            [compojure.route :refer [files not-found resources]]
            [compojure.handler :refer [site]]
            [pikseli.blog.index :as index-blog]
            [pikseli.portfolio.index :as index-portfolio]
            [pikseli.settings :as settings]
            [pikseli.blog.api.post-api :as post-api]
            [hiccup.core :refer :all]
            [stylefy.core :as stylefy]
            [reitit.ring :as ring]
            [reitit.coercion.spec]
            [org.httpkit.server :refer :all]
            [cognitect.transit :as transit]
            [clojure.string :as string]
            [pikseli.backend-styles :as backend-styles]
            [pikseli.common.router :as router])
  (:gen-class)
  (:import (java.io ByteArrayOutputStream)))

(defonce server (atom nil))

(defn stop []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn index [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (str "<!DOCTYPE html>" (stylefy/query-with-styles
                                     (fn []
                                       (let [{:keys [uri headers]} request
                                             host (get headers "host")]
                                         (backend-styles/create-constant-styles)
                                         (html (if (router/uri-is-blog? host uri)
                                                 (index-blog/index request)
                                                 (index-portfolio/index request)))))))})

(def handler
  (ring/ring-handler
    (ring/router
      ["/api"
       ["/post/:id" {:get {:parameters {:path {:id string?}}
                           ;:responses {200 {:metadata map? :html string?}}
                           :handler post-api/get-post}}]
       ["/post-metadata/:id" {:get {:parameters {:path {:id string?}}
                                    ;:responses {200 {:metadata map? :html string?}}
                                    :handler post-api/get-post-metadata}}]
       ["/post-ids" {:get {;:responses {200 {:body vector?}}
                           :handler post-api/get-posts}}]])))

(defn write-transit [response]
  (let [out (ByteArrayOutputStream. 4096)
        writer (transit/writer out :json)]

    (transit/write writer (:body response))

    (-> response
        (assoc-in [:headers "Content-Type"] "application/transit+json")
        (assoc :body (.toString out)))))

(defn app [request]
  (let [index-uri? (fn [uri] (or
                               (= uri "")
                               (= uri "/")
                               (string/starts-with? uri "/blog")))
        api-uri? (fn [uri] (string/starts-with? uri "/api"))]
    (cond
      (index-uri? (:uri request)) (index request)
      (api-uri? (:uri request)) (write-transit (handler request))
      :default {:status 404 :body "Not found"})))

(defn -main [& []]
  (settings/read-settings)
  (stylefy/init)
  (reset! server (run-server app {:port 8081})))