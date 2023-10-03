package com.example.spacee.authentication

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)