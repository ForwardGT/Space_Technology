package com.example.spacetechnology.features.auth.presentation

import com.example.spacetechnology.features.auth.domain.RegistrationErrors

data class RegistrationState(
    val email: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val errors: RegistrationErrors = RegistrationErrors(),
    val registrationSuccess: Boolean = false,
    val loginSuccess: Boolean = false
)