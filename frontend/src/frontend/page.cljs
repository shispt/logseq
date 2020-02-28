(ns frontend.page
  (:require [rum.core :as rum]
            [frontend.layout :as layout]
            [frontend.routes :as routes]
            [frontend.state :as state]))

(rum/defc current-page < rum/reactive
  []
  (let [state (rum/react state/state)
        current-page (get state :current-page :home)]
    (when-let [view (get routes/routes current-page)]
      (layout/frame (view) (:width state) (:add-link-dialog? state)))))