package com.example.unittestingexample.mock

data class User(
    val Id:Int,
    val name:String,
    val email:String,
    val password:String
)

enum class LOGIN_STATUS{
    INVALID_USER,
    INVALID_PASSWORD,
    UNKNOWN_ERROR,
    SUCCESS
}