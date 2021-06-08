(ns pikseli.common.styles.global
  (:require [stylefy.core :as stylefy]
            [stylefy.reagent :as stylefy-reagent]
            [pikseli.common.styles.settings :as style-settings]
            [garden.color :as color]))

;; ****************************************************************
;; Utils
;; ****************************************************************

(def center-block {:margin-left "auto"
                   :margin-right "auto"})

(def inline-block {:display "inline-block"})

(def hidden {:display "none"})

(def phone-max-width "450px")
(def tablet-max-width "1024px")

(defn on-mobile [style]
  {::stylefy/media {{:max-width tablet-max-width}
                    style}})

(defn on-tablet [style]
  {::stylefy/media {{:min-width phone-max-width
                     :max-width tablet-max-width}
                    style}})

(defn on-phone [style]
  {::stylefy/media {{:max-width phone-max-width}
                    style}})

;; ****************************************************************
;; Fonts & Colors
;; ****************************************************************

(def colors {:text                 (if style-settings/theme-dark? "#eaeaea" "#121212")
             :link                 (if style-settings/theme-dark? "#46aee5" "#b9511a")
             :selection            (if style-settings/theme-dark? "#9fdcfc" "#ffcfb5")
             :background-secondary "rgba(14, 31, 40, 0.85)"
             :error                "red"
             :header               (if style-settings/theme-dark? "#eaeaea" "#121212")
             :line                 "#5a5a5a"})

(def text-small {:font-size "0.8rem"})

;; ****************************************************************
;; Text
;; ****************************************************************

(stylefy/class "body-loaded" {:color (:text colors)})

(def text-center {:text-align :center})

(def text-smaller {:font-size "0.8rem"})

(def error-text
  (merge text-center
         {:color (:error colors)
          :margin-top "1rem"
          :margin-bottom "1rem"}))

;; ****************************************************************
;; Headings
;; ****************************************************************

(def h {:color (:header colors)})

(stylefy/tag "*" {::stylefy/mode {"::selection" {:background-color (:selection colors)}}})

(stylefy/tag "h1" (merge h
                         {:margin-top "1.5rem"
                          :margin-bottom "0.6rem"
                          :padding "0.5rem"
                          :font-size "1.6rem"
                          :font-weight :bold
                          ::stylefy/mode {:first-of-type {:margin-top 0}}
                          :border-bottom (str "0.1rem solid " (:header colors))
                          ::stylefy/scope [[:.full-blog-post
                                            {:text-transform :uppercase
                                             :text-align :center
                                             :border-bottom :none}]
                                           [:.blog-post-excerpt
                                            {:padding 0
                                             :border-bottom :none}]]}))

(stylefy/tag "h2" (merge h
                         {:margin-top "1rem"
                          :margin-bottom "1rem"
                          :font-size "1.2rem"}))

(stylefy/tag "h3" (merge h
                         {:font-size "1.1rem"}))

(stylefy/tag "h4" (merge h
                         {:font-size "1.0rem"
                          :margin-bottom "0"}))

;; ****************************************************************
;; Links & Buttons
;; ****************************************************************

(def clickable {:cursor "pointer"})
(def link {:color (:link colors)
           :text-decoration "none"
           :transition-property "color"
           :transition-duration "0.3s"
           ::stylefy/mode {:hover {:color (-> (:link colors)
                                              (color/lighten 10)
                                              (color/as-hex))}}})

(stylefy/tag "a" link)

(defn a-some-before [some]
  {::stylefy/mode
   {:before
    {:background-image (str "url(\"/images/some_" (name some) ".png\")")
     :background-repeat "no-repeat"
     :background-size "80%"
     :background-position "center center"
     :content "\"\""
     :margin-right "0.2rem"
     :padding-left "1.5rem"}}})

(def a-some (merge link
                   {:margin-top 0
                    :margin-bottom 0
                    :margin-right "0.5rem"
                    :height "2rem"}))

(def a-button (merge
                clickable
                {:display "block"
                :overflow "hidden"
                :min-width "120px"
                :height "35px"
                :color (:text colors)
                :margin-right "5px"
                :margin-bottom "5px"
                :text-align "center"
                :padding-top "5px"
                :padding-bottom "5px"
                :padding-left "10px"
                :padding-right "10px"
                :text-decoration "none"
                :box-shadow "0px 1px 3px rgba(000,000,000,0.5), inset 0px 0px 2px rgba(255,255,255,0.7)"
                :text-shadow "0px -1px 0px rgba(000,000,000,0.4), 0px 1px 0px rgba(255,255,255,0.3)"
                :background "linear-gradient(to bottom, #46a9de 0%, #1a527a)"
                ::stylefy/mode {:hover
                                {:background "linear-gradient(to bottom, #51bffb 0%, #216ca2)"}}
                :box-sizing "border-box"
                :border "1px solid black"
                :border-radius "5px"}))

;; ****************************************************************
;; API
;; ****************************************************************

(defn init-styles []
  (stylefy/init {:dom (stylefy-reagent/init)}))