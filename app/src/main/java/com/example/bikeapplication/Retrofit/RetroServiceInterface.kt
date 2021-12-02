package com.example.barbershopapp.retrofit


import com.example.bikeapplication.Entities.BikeEntity
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {

    @GET("getallbikes")
    fun getallbikes(): Call<List<BikeEntity>>

    @GET("getbikedescription/{id}")
    fun getbikedescription(
        @Path("id") id: String
    ): Call<BikeEntity>

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