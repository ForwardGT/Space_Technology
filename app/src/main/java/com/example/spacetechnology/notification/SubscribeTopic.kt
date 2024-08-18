package com.example.spacetechnology.notification

import com.google.firebase.Firebase
import com.google.firebase.messaging.messaging

fun subscribeTopicNews(
    subscribe: Boolean,
    topicName: String
) {
    if (subscribe) {
        Firebase.messaging.subscribeToTopic(topicName)
    } else {
        Firebase.messaging.unsubscribeFromTopic(topicName)
    }
}