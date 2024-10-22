package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.shorts.presentation.ShortsScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addShortsScreen(navController: NavController) {
    composable(Screen.MyShorts.route) {
        ShortsScreen(navController)
    }
}