package com.restaurant_online.component_notification

import android.content.Context
import com.restaurant_online.component_navigation.NotificationNavigation

class NotificationNavigationImpl: NotificationNavigation {

    override fun createNotification(context: Context, title: String, msg: String) {
        with(NotificationManager){
            createChannel(context)
            createNotification(context, title, msg)
        }
    }
}