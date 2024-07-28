package com.example.spacetechnology.core.utils.validators

import com.example.spacetechnology.features.auth.domain.AuthErrors

fun validatorLogin(
    email: String,
    password: String,
): AuthErrors {
    val emailError = when {
        email.isBlank() -> "Emails can't be blank"
        !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Incorrect Email"
        else -> ""
    }
    val passwordError = when {
        password.isBlank() -> "Password can't be blank"
        else -> ""
    }
    val repeatPasswordError = ""
    return AuthErrors(emailError, passwordError, repeatPasswordError)
}