package br.com.restaurant_online.controller

import com.restaurant_online.component_navigation.FoodDetailNavigation
import com.restaurant_online.component_navigation.MenuNavigation
import com.restaurant_online.component_navigation.NavigationController
import com.restaurant_online.component_navigation.NotificationNavigation
import com.restaurant_online.component_notification.NotificationNavigationImpl
import com.restaurant_online.feature_cart.CartMenuItemImpl
import com.restaurant_online.feature_food_detail.presenter.FoodDetailNavigationImpl
import com.restaurant_online.feature_home.HomeMenuItemImpl
import com.restaurant_online.feature_menu.MenuNavigationImpl

class NavigationControllerImpl: NavigationController {

    companion object {
        fun start() {
            NavigationController.instance = NavigationControllerImpl()
            NavigationController.menuItems = mutableMapOf(
                "home" to HomeMenuItemImpl(),
                "cart" to CartMenuItemImpl(),
            )
        }
    }

    override fun moduleMenu(): MenuNavigation {
        return MenuNavigationImpl()
    }

    override fun moduleFoodDetail(): FoodDetailNavigation {
        return FoodDetailNavigationImpl()
    }

    override fun moduleNotification(): NotificationNavigation {
        return NotificationNavigationImpl()
    }
}