package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.my_posts.presentation.CreateMyPostScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addCreateMyPostScreen(navController: NavController) {
    composable(Screen.CreateMyPostScreen.route) {
        CreateMyPostScreen(navController)
    }
}