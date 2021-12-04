package com.example.bikeapplication.Entities

data class BikeEntity(
    val _id: Id,
    val BikeType: String,
    val Brand: String,
    val Photo: String,
    val Price: String,
    val Description: String,
    val Status: Boolean,
    val UserComments: String,
    val UserRating: String,
    val UserType: String
)

data class SingleBikeEntity(
    val _id: Id,
    val BikeType: String,
    val Brand: String,
    val Photo: String,
    val Price: String,
    val Description: String,
    val Status: Boolean,
    val UserComments: String,
    val UserRating: String,
    val UserType: String
)

//@Entity(tableName = "RideList")
//data class RideList(
//
//    @SerializedName("SourceLocation")var SourceLocation : String,
//    @SerializedName("DestinationLocation")var DestinationLocation: String,
//    @SerializedName("Time")var Time: String,
//    @SerializedName("Date")var Date : String,
//    @SerializedName("seatsCount")var seatsCount: String,
//    @SerializedName("isOfferingRide")var isOfferingRide: String,
//    @SerializedName("isAskingRide")var isAskingRide: String,
//    @SerializedName("userId")var userId: String,
//    @PrimaryKey(autoGenerate = false) @SerializedName("rideId")var rideId: String){
//
//}