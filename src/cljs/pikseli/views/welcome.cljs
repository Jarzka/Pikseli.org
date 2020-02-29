(ns pikseli.views.welcome
  (:require [stylefy.core :refer [use-style sub-style use-sub-style]]
            [pikseli.styles.global :as g-styles]
            [pikseli.styles.layout :as layout]))

(defn welcome []
  [:div
   [:header
    [:div (use-sub-style layout/site-header :logo-and-description)
     [:a {:href "http://www.pikseli.org"}
      [:img (merge (use-sub-style layout/site-header :logo)
                   {:alt "pikseli.org" :src "images/logo.png"})]]
     [:span (use-sub-style layout/site-header :site-description)
      "Portfolio of Jari Hanhela"]]]

   [:section
    [:h1 "Welcome!"]
    [:p "This is a personal website / portfolio of Jari Hanhela, also known as Jarzka."]
    [:p "The site is the result of my creative mind. It contains projects related to "
     [:a {:href "#photography"} "photography"] [:span ", "]
     [:a {:href "#filming"} "filming"] [:span ", "]
     [:a {:href "#software"} "software"] [:span ", "]
     [:a {:href "#writing"} "writing"] [:span " and "]
     [:a {:href "#music"} "music"] [:span ". "]
     [:span "Feel free to explore!"]]
    [:p (use-style g-styles/text-small) "Contents updated: 29.2.2020."]]])