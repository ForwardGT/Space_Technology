package com.example.spacetechnology.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.example.spacetechnology.navigation.screens.addAuthScreen
import com.example.spacetechnology.navigation.screens.addFirstAuthScreen
import com.example.spacetechnology.navigation.screens.addHomeScreen
import com.example.spacetechnology.navigation.screens.addMyPostsScreen
import com.example.spacetechnology.navigation.screens.addNasaScreen
import com.example.spacetechnology.navigation.screens.addProfileScreen
import com.example.spacetechnology.navigation.screens.addRegistrationScreen
import com.example.spacetechnology.navigation.screens.addSpacexScreen

fun NavGraphBuilder.addSettingNavGraph(
    navController: NavController
) {
    addHomeScreen(navController)
    addNasaScreen(navController)
    addSpacexScreen(navController)
    addProfileScreen(navController)
    addFirstAuthScreen(navController)
    addAuthScreen(navController)
    addRegistrationScreen(navController)
    addMyPostsScreen(navController)
}