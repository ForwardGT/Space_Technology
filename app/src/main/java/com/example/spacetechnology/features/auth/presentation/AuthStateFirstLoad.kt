package com.example.spacetechnology.features.auth.presentation

import com.example.spacetechnology.navigation.Screen

sealed class AuthStateFirstLoad(
    val route: String
) {

    data object Loading : AuthStateFirstLoad("")

    data object Authorised : AuthStateFirstLoad(Screen.HomeScreen.route)

    data object NotAuthorised : AuthStateFirstLoad(Screen.FirstAuthScreen.route)

}
