(ns voimala.styles.layout
  (:require [stylefy.core :as stylefy]
            [voimala.styles.shared :as shared-styles]
            [garden.color :as color]))

(def media-breakpoint "780px")

(def dark-box {:border-radius "5px"
               :background-color "rgba(0, 0, 0, 0.9)"
               :border "1px solid rgba(255, 255, 255, 0.1)"})

(def site-header
  (merge
    dark-box
    {:display "flex"
     :flex-direction "row"
     :justify-content "center"
     :height "80px"
     :align-items "center"
     :padding-bottom "7px"
     :padding-top "7px"
     ::stylefy/sub-styles
     {:logo-and-description {:text-align "center"}
      :logo {:display :block ;
             :margin-left "auto"
             :margin-right "auto"
             :width "290px"
             :height "55px"
             :max-height "93px"
             :max-width "500px"}
      :site-description {:padding-top "5px"
                         :padding-bottom "5px"}
      :site-navigation {:padding-left "25px"
                        :Padding-right "25px"
                        ::stylefy/media {{:max-width media-breakpoint}
                                         {:padding-top "10px"
                                          :padding-bottom "10px"}}}}
     ::stylefy/media {{:max-width media-breakpoint}
                      {:flex-direction :column
                       :height "auto"}}}))