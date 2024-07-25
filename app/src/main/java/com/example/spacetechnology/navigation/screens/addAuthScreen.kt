package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.auth.presentation.AuthScreen
import com.example.spacetechnology.features.home.presentation.HomeScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addAuthScreen(navController: NavController) {
    composable(Screen.AuthScreen.route) {
        AuthScreen(navController = navController)
    }
}