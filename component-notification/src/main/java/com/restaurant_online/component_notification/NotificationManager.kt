package com.restaurant_online.component_notification

import android.app.NotificationChannel
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationManager {

    private const val CHANNEL_ID = "1"

    fun createChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val manager = context.getSystemService(
                Context.NOTIFICATION_SERVICE
            ) as android.app.NotificationManager

            val channel = NotificationChannel(
                CHANNEL_ID,
                context.getString(R.string.app_name),
                android.app.NotificationManager.IMPORTANCE_DEFAULT
            )

            manager.createNotificationChannel(channel)
        }
    }

    fun createNotification(context: Context, title: String, msg: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val manager = context.getSystemService(
                Context.NOTIFICATION_SERVICE
            ) as android.app.NotificationManager

            val notification = NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(msg)
                .setSmallIcon(R.drawable.ic_food)
                .setAutoCancel(true)
                .build()

            manager.notify(CHANNEL_ID.toInt(), notification)
        }
    }
}