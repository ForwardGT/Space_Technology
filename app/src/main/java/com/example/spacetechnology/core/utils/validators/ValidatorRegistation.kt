package com.example.spacetechnology.core.utils.validators

import com.example.spacetechnology.features.auth.domain.RegistrationErrors

fun validatorRegistration(
    email: String,
    password: String,
    repeatPassword: String
): RegistrationErrors {
    val emailError = when {
        email.isBlank() -> "Emails can't be blank"
        !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Incorrect Email"
        else -> ""
    }
    val passwordError = when {
        password.isBlank() -> "Password can't be blank"
        else -> ""
    }
    val repeatPasswordError = when {
        repeatPassword.isBlank() -> "Repeat the password"
        password != repeatPassword -> "The passwords don't match"
        else -> ""
    }
    return RegistrationErrors(emailError, passwordError, repeatPasswordError)
}