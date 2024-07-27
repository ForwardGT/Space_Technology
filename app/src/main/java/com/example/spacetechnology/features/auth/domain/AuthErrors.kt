package com.example.spacetechnology.features.auth.domain

data class AuthErrors(
    val emailError: String = "",
    val passwordError: String = "",
    val repeatPasswordError: String = "",
)