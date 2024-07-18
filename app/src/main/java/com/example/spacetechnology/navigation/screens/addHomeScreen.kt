package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.home.presentation.HomeScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addHomeScreen(navController: NavController) {
    composable(Screen.HomeScreen.route) {
        HomeScreen()
    }
}