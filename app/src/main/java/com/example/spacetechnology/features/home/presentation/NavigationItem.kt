package com.example.spacetechnology.features.home.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.spacetechnology.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val nameItem: String,
    val icon: ImageVector
) {
    data object Home : NavigationItem(
        screen = Screen.HomeScreen,
        nameItem = "Home",
        icon = Icons.Filled.Home
    )

    data object SpaceX : NavigationItem(
        screen = Screen.SpacexScreen,
        nameItem = "SpaceX",
        icon = Icons.Filled.RocketLaunch
    )

    data object Nasa : NavigationItem(
        screen = Screen.NasaScreen,
        nameItem = "NASA",
        icon = Icons.Filled.Public
    )

    data object Profile : NavigationItem(
        screen = Screen.ProfileScreen,
        nameItem = "Profile",
        icon = Icons.Filled.Person
    )
}