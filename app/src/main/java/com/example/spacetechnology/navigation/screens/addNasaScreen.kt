package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.nasa.presentation.NasaScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addNasaScreen(navController: NavController) {
    composable(Screen.NasaScreen.route) {
        NasaScreen(navController = navController)
    }
}