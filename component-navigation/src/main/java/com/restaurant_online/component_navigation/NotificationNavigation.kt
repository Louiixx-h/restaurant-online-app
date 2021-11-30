package com.restaurant_online.component_navigation

import android.content.Context

interface NotificationNavigation {

    fun createNotification(context: Context, title: String, msg: String)
}
