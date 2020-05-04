(ns pikseli.api.post-api
  (:require [clojure.java.io :as io]
            [pikseli.settings :as settings]
            [markdown.core :refer [md-to-html-string-with-meta]]
            [clojure.string :as string]))

(defn get-post [{:keys [path-params] :as request}]
  (let [id (:id path-params)
        contents (slurp (io/file
                          (str (settings/resources-on-disk)
                               "blog_posts/"
                               id
                               ".md")))
        blog-post (md-to-html-string-with-meta contents)]
    {:status 200
     :body blog-post}))


(defn get-posts [_request]
  ; FIXME Page id is ignored, implement support later
  (let [contents (slurp (io/file
                          (str (settings/resources-on-disk) "blog_posts/posts.txt")))
        lines (string/split-lines contents)
        lines-stored (sort lines)]
  {:status 200
   :body (vec lines-stored)}))