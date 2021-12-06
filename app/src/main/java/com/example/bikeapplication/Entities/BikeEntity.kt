package com.example.bikeapplication.Entities

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

data class SingleBikeEntity(
    val BikeType: String,
    val Brand: String,
    val Description: String,
    val PickupLocation: String,
    val UserType: String,
    val VendorName: String,
    val Price:String
)