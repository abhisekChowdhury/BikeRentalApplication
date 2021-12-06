package com.example.barbershopapp.retrofit


import com.example.bikeapplication.Entities.BikeEntity
import com.example.bikeapplication.Entities.SingleBikeEntity
import com.example.bikeapplication.Entities.SingleUserEntity
import com.example.bikeapplication.Entities.UserEntity
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

//    @GET("getSingle/{id}")
//    fun getSingleBarber(
//        @Path("id") id: String
//    ): Call<GetAllBarberItem>
//
//    @GET("getSingleAppointment/{id}")
//    fun getSingleAppointment(
//        @Path("id") id: String
//    ): Call<GetAllAppointment>
//
//    @PUT("update/{id}")
//    fun updateSingleBarber(
//        @Path("id") id: String
//    ): Call<GetAllBarberItem>
//
//    @POST("add")
//    @Headers("Accept:application/json", "Content-Type:application/json")
//    fun addSingleBarber(@Body params: GetSingleBarber):Call<Any>
//
//    @PATCH("patch/{id}")
//    @Headers("Accept:application/json", "Content-Type:application/json")
//    fun addAppointment(@Path("id")id: String, @Body params: GetSingleAppointment):Call<Any>

}