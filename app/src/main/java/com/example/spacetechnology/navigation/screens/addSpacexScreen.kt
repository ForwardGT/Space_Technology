package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.spacex.presentation.SpacexScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addSpacexScreen(navController: NavController) {
    composable(Screen.SpacexScreen.route) {
        SpacexScreen()
    }
}