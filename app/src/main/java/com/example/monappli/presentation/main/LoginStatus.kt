package com.example.monappli.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()

object LoginError : LoginStatus()

object LoginCreate : LoginStatus()

