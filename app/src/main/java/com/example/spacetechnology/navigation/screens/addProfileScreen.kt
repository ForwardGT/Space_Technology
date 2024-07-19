package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.profile.presentation.ProfileScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addProfileScreen(navController: NavController) {
    composable(Screen.ProfileScreen.route) {
        ProfileScreen(navController = navController)
    }
}