(ns pikseli.styles.views.blog
  (:require [stylefy.core :as stylefy]
            [garden.color :as color]
            [garden.stylesheet :refer [at-media]]
            [pikseli.styles.global :as g-styles]))

(def blog-post {:font-family "Georgia, Garamond"})

(def blog-post-full
  (merge
    blog-post
    {::stylefy/manual [[:img
                        {:display :block
                         :margin-left :auto
                         :margin-right :auto
                         :margin-top "0.5rem"
                         :margin-bottom "0.5rem"
                         :width "80%"}]
                       (at-media {:max-width g-styles/tablet-max-width}
                                 [:img {:width "100%"}])]}))

(def blog-post-excerpt
  (merge
    blog-post
    {::stylefy/manual [[:img
                        {:display :block
                         :margin-left :auto
                         :margin-right :auto
                         :margin-top "0.5rem"
                         :margin-bottom "0.5rem"
                         :object-fit :cover
                         :width "100%"
                         :height "23rem"}]]}))

(def header {:position :relative})

(def top-links (merge
                 {:position :absolute
                  :display :flex
                  :width "100%"}
                 (g-styles/on-mobile
                   {:position :static
                    :margin-bottom "1rem"})))

(def back {:flex 1
           :padding "0.1rem"
           :text-align :left})
(def about {:flex 1
            :display :block
            :padding "0.1rem"
            :text-align :right})

(def about-page {:margin-top "1rem"})

(def about-frame
  (merge
    {:display :flex
    :margin "1rem"}
    (g-styles/on-phone
      {:flex-flow :column})))

(def about-image-frame {:flex 1})
(def about-image {:width "100%"
                  :padding "1rem"
                  :border-radius "100%"})
(def about-text {:flex 3
                 :margin-top "1rem"})

(def blog-post-frontpage {:font-size "1rem"
                          :text-align :center
                          :display :flex
                          :justify-content :center
                          :flex-wrap :wrap})

(def footer-link (merge-with merge
                             {:padding-right "1.3rem"
                              :padding-left "1.3rem"}
                             (g-styles/on-tablet
                               {:padding-right "0.7rem"
                                :padding-left "0.7rem"})
                             (g-styles/on-phone
                               {:width "100%"
                                :margin-top "0.5rem"})))

(def author-and-date {:margin-bottom "1rem"
                      :position :relative
                      :top "-0.5rem"
                      :font-size "0.7rem"
                      :color "#5a5a5a"})

(def blog-content {:min-height "1500px"})