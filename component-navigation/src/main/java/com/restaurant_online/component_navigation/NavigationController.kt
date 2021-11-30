package com.restaurant_online.component_navigation

interface NavigationController {

    companion object {
        var instance: NavigationController? = null
        var menuItems: MutableMap<String, IMenuItem>? = null
    }

    fun moduleMenu(): MenuNavigation
    fun moduleFoodDetail(): FoodDetailNavigation
    fun moduleNotification(): NotificationNavigation
}