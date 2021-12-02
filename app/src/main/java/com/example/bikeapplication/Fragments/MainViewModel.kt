package com.example.bikeapplication.Fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barbershopapp.retrofit.RetroInstance
import com.example.barbershopapp.retrofit.RetroServiceInterface
import com.example.bikeapplication.Entities.BikeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    lateinit var liveDataList: MutableLiveData<List<BikeEntity>?>
    lateinit var liveData: MutableLiveData<BikeEntity?>

    init {
        liveDataList = MutableLiveData()
        liveData = MutableLiveData()
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

//    fun addUserAccount(userAccount: Users) {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                database?.userAccountsDao()?.insertUser(userAccount)
//            }
//        }
//    }

}