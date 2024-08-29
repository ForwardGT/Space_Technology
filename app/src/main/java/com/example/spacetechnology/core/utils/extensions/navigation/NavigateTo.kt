package com.example.spacetechnology.core.utils.extensions.navigation

import androidx.navigation.NavController

fun NavController.navigateTo(
    urlScreen: String
) {
    navigate(urlScreen) {
        launchSingleTop = true
    }
}
