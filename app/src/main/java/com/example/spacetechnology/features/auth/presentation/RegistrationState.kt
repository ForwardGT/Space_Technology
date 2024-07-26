package com.example.spacetechnology.features.auth.presentation

data class RegistrationState(
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",
)
