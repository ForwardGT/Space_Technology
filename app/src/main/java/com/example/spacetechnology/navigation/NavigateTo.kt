package com.example.spacetechnology.navigation

import androidx.navigation.NavController

fun NavController.navigateTo(
    urlScreen: String
) {
    navigate(urlScreen) {
        launchSingleTop = true
    }
}