package com.example.spacetechnology.notification

import android.app.NotificationManager

sealed class ChanelInformation(
    val name: String,
    val description: String,
    val id: String,
    val notificationLVL: Int
) {
    data object ChanelNews : ChanelInformation(
        name = "news",
        description = "Notification news",
        id = "1",
        notificationLVL = NotificationManager.IMPORTANCE_DEFAULT
    )

    data object ChanelSales : ChanelInformation(
        name = "sales",
        description = "Notification sales",
        id = "",
        notificationLVL = NotificationManager.IMPORTANCE_DEFAULT
    )
}