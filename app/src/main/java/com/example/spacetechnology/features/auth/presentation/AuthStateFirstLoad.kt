package com.example.spacetechnology.features.auth.presentation

sealed class AuthStateFirstLoad {

    data object Loading: AuthStateFirstLoad()

    data object Authorised: AuthStateFirstLoad()

    data object NotAuthorised: AuthStateFirstLoad()

}
