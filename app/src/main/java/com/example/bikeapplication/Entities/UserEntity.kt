package com.example.bikeapplication.Entities

data class UserEntity(
    val Address: String,
    val FullName: String,
    val UserName: String,
    val _id: Id,
    val Password: String
)

data class SingleUserEntity(
    val FullName: String,
    val UserName: String,
    val Address: String,
    val Password: String
)