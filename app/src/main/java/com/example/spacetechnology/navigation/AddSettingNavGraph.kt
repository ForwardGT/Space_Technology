package com.example.spacetechnology.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.spacetechnology.navigation.screens.addHomeScreen

fun NavGraphBuilder.addSettingNavGraph(navController: NavController) {
    addHomeScreen(navController)
}