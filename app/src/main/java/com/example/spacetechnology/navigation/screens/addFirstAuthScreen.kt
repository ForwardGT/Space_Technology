package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.auth.presentation.FirstAuthScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addFirstAuthScreen(navController: NavController) {
    composable(Screen.FirstAuthScreen.route) {
        FirstAuthScreen(navController = navController)
    }
}