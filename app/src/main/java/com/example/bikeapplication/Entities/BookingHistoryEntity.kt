package com.example.bikeapplication.Entities

data class BookingHistoryEntity(
    val AmountPaid: String,
    val BikeBrand: String,
    val FullName: String,
    val PickupLocation: String,
    val UserName: String,
    val VendorName: String,
    val _id: Id
)

data class SingleBookingHistoryEntity(
    val AmountPaid: String,
    val BikeBrand: String,
    val FullName: String,
    val PickupLocation: String,
    val UserName: String,
    val VendorName: String,
)