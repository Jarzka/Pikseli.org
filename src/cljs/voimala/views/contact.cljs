(ns voimala.views.contact
  (:require [stylefy.core :refer [use-style sub-style use-sub-style]]
            [voimala.ui.general :as ui]))

(defn contact []
  [:div
   [:a {:id "contact"}]
   [:h1 "Contact"]
   [:h2 "Email"]
   [:p "You can contact me by email: jarihanhela (at) gmail.com."]
   [:h2 "Social media"]
   [ui/social-media-link {:some-type :instagram :href "https://instagram.com/jarzka.90"} "Instagram"]
   [ui/social-media-link {:some-type :github :href "https://github.com/Jarzka"} "GitHub"]
   [ui/social-media-link {:some-type :gitlab :href "https://gitlab.com/Jarzka"} "GitLab"]
   [ui/social-media-link {:some-type :linkedin :href "http://lnkd.in/5JP3nQ"} "LinkedIn"]
   [ui/social-media-link {:some-type :twitter :href "https://twitter.com/jarzka"} "Twitter"]
   [ui/social-media-link {:some-type :youtube :href "https://www.youtube.com/channel/UC1xtM_UXTnSuqmvoBem-cFA"} "YouTube (JarzkaCodes)"]
   [ui/social-media-link {:some-type :youtube :href "https://www.youtube.com/channel/UCLY7kXdrpY_9RONQPN0J71w"} "YouTube (JarzkaPlays)"]])