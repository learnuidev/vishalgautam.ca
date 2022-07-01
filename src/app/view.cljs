(ns app.view)

(defn link-tree []
  [:div {:style {:display "flex"
                 :flex-direction "column"
                 :padding 16}}
    [:a {:href "https://www.youtube.com/channel/UCMzFPki9OSIe2ER7ENhnL0g"
         :style {:margin "16px 0px"}
         :target "_blank"}
      "YouTube Channel"]
    [:a {:href "https://github.com/Novus-School/novus/tree/master/notes/novus_school/courses/immutable_stack_book_v1"
         :style {:margin "16px 0px"}
         :target "_blank"}
      "Immutable Stack [WIP] - Book"]
    [:a {:href "https://github.com/learnuidev"
         :style {:margin "16px 0px"}
         :target "_blank"}
      "github"]])

(defn app []
  [:div
   [:h4 "Link tree"]
   [link-tree]])
