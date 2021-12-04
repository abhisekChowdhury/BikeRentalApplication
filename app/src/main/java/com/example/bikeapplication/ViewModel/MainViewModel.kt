package com.example.bikeapplication.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barbershopapp.retrofit.RetroInstance
import com.example.barbershopapp.retrofit.RetroServiceInterface
import com.example.bikeapplication.Entities.BikeEntity
import com.example.bikeapplication.Entities.SingleBikeEntity
import com.example.bikeapplication.Entities.SingleUserEntity
import com.example.bikeapplication.Entities.UserEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    lateinit var liveDataList: MutableLiveData<List<BikeEntity>?>
    lateinit var liveData: MutableLiveData<BikeEntity?>
    lateinit var liveDataUser: MutableLiveData<UserEntity?>

    init {
        liveDataList = MutableLiveData()
        liveData = MutableLiveData()
        liveDataUser = MutableLiveData()
    }

    fun backendBikeList() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.getallbikes()
        call.enqueue(object : Callback<List<BikeEntity>> {
            override fun onFailure(call: Call<List<BikeEntity>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<BikeEntity>>,
                response: Response<List<BikeEntity>>
            ) {
                liveDataList.postValue(response.body())
            }
        })


    }

    fun backendBikeDetails(id:String) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.getbikedescription(id)
        call.enqueue(object : Callback<BikeEntity> {
            override fun onFailure(call: Call<BikeEntity>, t: Throwable) {
                liveData.postValue(null)
            }

            override fun onResponse(
                call: Call<BikeEntity>,
                response: Response<BikeEntity>
            ) {
                liveData?.postValue(response.body())
            }
        })
    }

    fun backendgetusernamepassword(UserName:String) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.findusernamepassword(UserName)
        call.enqueue(object : Callback<UserEntity> {
            override fun onFailure(call: Call<UserEntity>, t: Throwable) {
                liveDataUser.postValue(null)
            }

            override fun onResponse(
                call: Call<UserEntity>,
                response: Response<UserEntity>
            ) {
                liveDataUser?.postValue(response.body())
            }
        })
    }

    fun backendAddUser(body: SingleUserEntity) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.adduser(body)
        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i("failure add user ","failed")
            }

            override fun onResponse(
                call: Call<Any>,
                response: Response<Any>
            ) {
                //Log.i("response add user ", "aaaaa")
                //Log.i("Data: ", (response.body() as SingleUserEntity?).toString())
            }
        })
    }

    fun backendAddBike(body: SingleBikeEntity) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.addbike(body)
        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i("failure add user ","failed")
            }

            override fun onResponse(
                call: Call<Any>,
                response: Response<Any>
            ) {
                //Log.i("response add user ", "aaaaa")
                //Log.i("Data: ", (response.body() as SingleUserEntity?).toString())
            }
        })
    }

}