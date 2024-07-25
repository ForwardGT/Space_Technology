package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.auth.presentation.RegistrationScreen
import com.example.spacetechnology.features.home.presentation.HomeScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addRegistrationScreen(navController: NavController) {
    composable(Screen.RegistrationScreen.route) {
        RegistrationScreen(navController = navController)
    }
}