package com.example.spacetechnology.navigation.screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.spacetechnology.features.my_posts.presentation.MyPostsScreen
import com.example.spacetechnology.navigation.Screen

fun NavGraphBuilder.addMyPostsScreen(navController: NavController) {
    composable(Screen.MyPostsScreen.route) {
        MyPostsScreen(navController)
    }
}