package com.example.barbershopapp.retrofit


import com.example.bikeapplication.Entities.*
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {

    @GET("getallbikes")
    fun getallbikes(): Call<List<BikeEntity>>

    @GET("getallbikes1")
    fun getallbikes1(): Call<List<SingleBikeEntity>>

    @GET("getbikedescription/{id}")
    fun getbikedescription(
        @Path("id") id: String
    ): Call<BikeEntity>

    @POST("adduser")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun adduser(@Body params: SingleUserEntity):Call<Any>

    @POST("addbike")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun addbike(@Body params: SingleBikeEntity):Call<Any>

    @GET("findusernamepassword/{username}")
    fun findusernamepassword(
        @Path("username") UserName: String
    ): Call<UserEntity>

    @GET("findbookingbyusername/{username}")
    fun findbookingbyusername(
        @Path("username") UserName: String
    ): Call<BookingHistoryEntity>

    @POST("addbookinghistory")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun addbookinghistory(@Body params: SingleBookingHistoryEntity):Call<Any>
}