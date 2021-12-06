package com.example.bikeapplication.LocalDB

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bikeapplication.Entities.SingleBikeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BikeApplicationViewModel(app: Application) : AndroidViewModel(app) {
    val database = AppDatabase.getInstance(app)
    var listofUsers = database?.BikeApplicationAPI()?.getAllUsers()
    var listofBikes = database?.BikeApplicationAPI()?.getAllBikes()


    fun insertListOfUsers(mylist: List<SingleBikeEntity>){
        viewModelScope.launch {
            // Dispatchers.IO means run this in the background
            withContext(Dispatchers.IO) {

                database?.BikeApplicationAPI()?.insertAllUsers(mylist)
            }
        }
    }
    fun insertListOfBikes(mylist: List<SingleBikeEntity>){
        viewModelScope.launch {
            // Dispatchers.IO means run this in the background
            withContext(Dispatchers.IO) {

                database?.BikeApplicationAPI()?.insertAllBikes(mylist)
            }
        }
    }
}