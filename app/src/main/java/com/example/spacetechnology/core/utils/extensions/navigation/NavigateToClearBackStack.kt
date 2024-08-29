package com.example.spacetechnology.core.utils.extensions.navigation

import androidx.navigation.NavController

fun NavController.navigateToClearBackStack(
    urlScreen: String
) {
    navigate(urlScreen) {
        popUpTo(urlScreen) {
            inclusive = true
        }
    }
}
