package com.example.spacetechnology.features.auth.domain

data class AuthErrors(
    val emailError: String = "",
    val passwordError: String = "",
    val repeatPasswordError: String = "",
) {
    companion object {
        const val UNKNOWN_ERROR = "UNKNOWN ERROR"
        const val WRONG_PASSWORD = "WRONG PASSWORD"
        const val EMAIL_DOES_NOT_EXIST = "EMAIL DOES NOT EXIST"
    }
}