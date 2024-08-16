package com.example.spacetechnology.notification

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

fun getTokenFromNotification() {
    FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
        if (!task.isSuccessful) {
            Log.w("ERROR TOKEN", "Fetching FCM registration token failed", task.exception)
            return@OnCompleteListener
        }

        val token = task.result
        Log.d("TAG", "token: $token")
    })
}