package com.example.spacetechnology.navigation

sealed class Screen(
    val route: String
) {
    data object HomeScreen : Screen(HOME_SCREEN)

    data object SpacexScreen : Screen(SPACEX_SCREEN)

    data object NasaScreen : Screen(NASA_SCREEN)

    data object ProfileScreen : Screen(PROFILE_SCREEN)

    data object FirstAuthScreen : Screen(FIRST_AUTH_SCREEN)

    data object AuthScreen : Screen(AUTH_SCREEN)

    data object RegistrationScreen : Screen(REGISTRATION_SCREEN)


    private companion object {
        const val HOME_SCREEN = "home"
        const val SPACEX_SCREEN = "spacex"
        const val NASA_SCREEN = "nasa"
        const val PROFILE_SCREEN = "profile"
        const val FIRST_AUTH_SCREEN = "first"
        const val AUTH_SCREEN = "auth"
        const val REGISTRATION_SCREEN = "registration"
    }
}