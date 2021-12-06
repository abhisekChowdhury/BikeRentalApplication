package com.example.bikeapplication.LocalDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bikeapplication.Entities.SingleBikeEntity
import com.example.bikeapplication.Entities.SingleUserEntity

@Dao
interface BikeApplicationAPI {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // it performs an update if it exists
    fun insertAllUsers(SingleUserEntity: List<SingleBikeEntity>)

    @Query("SELECT * FROM SingleUserEntity")
    fun getAllUsers(): LiveData<List<SingleUserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // it performs an update if it exists
    fun insertAllBikes(SingleBikeEntity: List<SingleBikeEntity>)

    @Query("SELECT * FROM SingleBikeEntity")
    fun getAllBikes(): LiveData<List<SingleBikeEntity>>
}
