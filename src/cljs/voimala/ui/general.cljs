(ns voimala.ui.general
  (:require [stylefy.core :as stylefy :refer [use-style]]
            [voimala.styles.global :as g-styles]))

(defn- with-unique-keys [content]
  (map-indexed
    (fn [index element]
      ^{:key index}
      [:span element])
    content))

(defn social-media-link [{:keys [some-type] :as options} & content]
  [:a (use-style (merge-with merge
                             g-styles/a-some
                             (g-styles/a-some-before some-type))
                 (dissoc options :some-type))
   content])

(defn button-link [{:keys [button-icon extra-styles] :as options} & content]
  [:a (use-style (merge
                   g-styles/a-button
                   extra-styles)
                 (dissoc options :button-icon :extra-styles))
   content])

(defn button [{:keys [button-icon extra-styles] :as options} & content]
  [:button (use-style (merge
                   g-styles/a-button
                   extra-styles)
                 (dissoc options :button-icon :extra-styles))
   content])

(defn blockquote [text person]
  [:blockquote
   [:p (str "\"" text "\"")
    [:br] (str "- " person)]])