package com.example.bikeapplication.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class UserEntity(

    val Address: String,
    val FullName: String,
    val UserName: String,
    val _id: Id,
    val Password: String
)

@Entity(tableName = "SingleUserEntity")
data class SingleUserEntity(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("FullName")val FullName: String,
    @SerializedName("UserName")val UserName: String,
    @SerializedName("Address")val Address: String,
    @SerializedName("Password")val Password: String
)