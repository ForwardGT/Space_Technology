package com.example.spacetechnology.features.auth.presentation

import com.example.spacetechnology.features.auth.domain.AuthErrors

data class AuthState(
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val errors: AuthErrors = AuthErrors(),
    val registrationSuccess: Boolean = false,
    val loginSuccess: Boolean = false
)