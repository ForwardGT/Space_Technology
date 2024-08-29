package com.example.spacetechnology.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color.rgb

fun createNotificationChannels(context: Context) {

    val chanelInfo = listOf(ChanelInformation.ChanelNews, ChanelInformation.ChanelSales)
    val chanelRegistration = mutableListOf<NotificationChannel>()

    chanelInfo.forEach { chanel ->
        val createChanel = NotificationChannel(
            chanel.id, chanel.description, chanel.notificationLVL
        ).apply {
            lightColor = rgb(102, 205, 170)
            description = chanel.description
        }
        chanelRegistration.add(createChanel)
    }

    val notificationManager = context.getSystemService(NotificationManager::class.java)
    notificationManager.createNotificationChannels(chanelRegistration)
}