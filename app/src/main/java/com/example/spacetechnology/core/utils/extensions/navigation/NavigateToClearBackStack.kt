package com.example.spacetechnology.core.utils.extensions.navigation

import androidx.navigation.NavController
import com.example.spacetechnology.navigation.Screen

fun NavController.navigateToClearBackStack(
    urlScreen: String
) {
    navigate(urlScreen) {
        popUpTo(Screen.RegistrationScreen.route) {
            inclusive = true
        }
    }
}