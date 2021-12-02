package com.example.bikeapplication.Entities

data class UserEntity(
    val Address: String,
    val CardNumber: String,
    val FullName: String,
    val _id: Id,
    val email: String,
    val password: String
)