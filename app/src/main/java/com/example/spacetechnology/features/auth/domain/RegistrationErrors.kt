package com.example.spacetechnology.features.auth.domain

data class RegistrationErrors(
    val emailError: String = "",
    val passwordError: String = "",
    val repeatPasswordError: String = "",
)