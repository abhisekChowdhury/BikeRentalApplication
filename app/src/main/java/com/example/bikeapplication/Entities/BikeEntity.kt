package com.example.bikeapplication.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class BikeEntity(

    val BikeType: String,
    val Brand: String,
    val Description: String,
    val PickupLocation: String,
    val UserType: String,
    val VendorName: String,
    val Price:String,
    val _id: Id
)

@Entity(tableName = "SingleBikeEntity")
data class SingleBikeEntity(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("BikeType")val BikeType: String,
    @SerializedName("Brand")val Brand: String,
    @SerializedName("Description")val Description: String,
    @SerializedName("PickupLocation")val PickupLocation: String,
    @SerializedName("UserType")val UserType: String,
    @SerializedName("VendorName")val VendorName: String,
    @SerializedName("Price")val Price:String
)