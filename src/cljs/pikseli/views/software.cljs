(ns pikseli.views.software
  (:require [reagent.core :as r]
            [cljs-time.core :as t]
            [cljs-time.format :as f]
            [stylefy.core :refer [use-style sub-style use-sub-style]]
            [pikseli.ui.general :as ui]
            [pikseli.styles.views.software :as pstyle]
            [pikseli.styles.global :as g-styles]))

(defn- libraries []
  [:div
   [:h2 "Software libraries"]
   [:ul
    [:li
     [:a {:href "https://github.com/Jarzka/namespacefy"}
      "namespacefy"]
     [:span " "]
     "is a simple Clojure(Script) library which aims to make it easy to keep keys namespaced."]
    [:li
     [:a {:href "https://github.com/Jarzka/stylefy"}
      "stylefy"]
     [:span " "]
     " makes it possible to define UI component styles as Clojure data."]]])

(defn project-card [{:keys [title date live-demo video source-code image-file desc]}]
  [:div.card (use-style pstyle/card)
   [:img.card-img-top {:alt "", :src (str "images/" image-file)}]
   [:div.card-body
    [:h5.card-title title]
    [:p.card-text desc]
    (when live-demo
      [:a.card-link {:href live-demo} "Live demo"])
    (when video
      [:a.card-link {:href video} "Video"])
    (when source-code
      [:a.card-link {:href source-code} "Source code"])]
   [:div.card-footer [:small.text-muted date]]])

(defn- software-projects []
  (let [show-more? (r/atom false)]
    (fn []
      [:div
       [:div.card-deck (use-style pstyle/card-deck)
        [project-card {:title "Ajokit"
                       :source-code "https://github.com/Jarzka/Ajokit"
                       :live-demo "projects/ajokit"
                       :image-file "ajokit.jpg"
                       :date "10.10.2015"
                       :desc "A simple grid-based traffic simulation application which also has a real-time map editing capability. Technologies: JavaScript & Three.js."}]
        [project-card {:title "Solita Rooms"
                       :source-code "https://github.com/solita/solita-rooms"
                       :image-file "rooms2.png"
                       :date "1.5.2018"
                       :desc "Solita Rooms is a web application which can be used to view Microsoft Exchange room bookings. Technologies: ClojureScript & C#."}]
        [project-card {:title "JarzkaChess"
                       :source-code "https://github.com/Jarzka/JarzkaChess"
                       :image-file "jarzkachess.png"
                       :date "15.2.2014"
                       :video "https://www.youtube.com/watch?v=viFZeI8uAVU"
                       :desc "A chess game which includes an artifical intelligence to challenge beginning chess players. Technologies: Java."}]]

       [:div (use-style (when-not @show-more? g-styles/hidden))
        [:div.card-deck (use-style pstyle/card-deck)
         [project-card {:title "MyRTS"
                        :source-code "https://github.com/Jarzka/MyRTS"
                        :image-file "myrts.jpg"
                        :date "18.4.2014"
                        :video "https://www.youtube.com/watch?v=OEy6PhbeE_Y"
                        :desc [:span
                               "Multiplayer RTS prototype. The architecture supports some basic features like giving simple commands to units and synchronizing the game over network using simultaneous simulations with"
                               " " [:a {:href "https://www.gamasutra.com/view/feature/131503/1500_archers_on_a_288_network_.php"} "lockstep-like model"]
                               ". Technologies: Java & libgdx."]}]
         [project-card {:title "PresentationApp"
                        :image-file "presentation_app.png"
                        :source-code "https://github.com/Jarzka/PresentationApp"
                        :date "25.8.2014"
                        :live-demo "projects/presentation_app"
                        :desc "A simple HTML5 application that can be used to create PowerPoint-like presentations. Technologies: JavaScript."}]

         [project-card {:title "ThisSimpleMarquee"
                        :image-file "thissimplemarquee.png"
                        :source-code "https://github.com/Jarzka/ThisSimpleMarquee"
                        :live-demo "projects/thissimplemarquee/"
                        :date "4.9.2014"
                        :desc "A simple HTML5 marquee library. Technologies: JavaScript."}]]
        [libraries]
        [:p "See all of my public software projects on my"
         " "
         [:a {:href "https://github.com/Jarzka"} "GitHub profile"]
         "."]]

       (when-not @show-more?
         [ui/button {:on-click #(reset! show-more? true)} "Show more software projects"])])))

(defn software []
  [:section
   [:a {:id "software"}]
   [:h1 "Software"]
   [ui/blockquote
    "Our civilization depends critically on software; it had better be quality software."
    "Bjarne Stroustrup"]
   [software-projects]])
