package com.example.spacetechnology.navigation

sealed class Screen(
    val route: String
) {
    data object HomeScreen : Screen(HOME_SCREEN)


    private companion object {
        const val HOME_SCREEN = "home"
    }
}