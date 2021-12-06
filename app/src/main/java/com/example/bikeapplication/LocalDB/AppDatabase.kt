package com.example.bikeapplication.LocalDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bikeapplication.Entities.BikeEntity
import com.example.bikeapplication.Entities.SingleBikeEntity
import com.example.bikeapplication.Entities.SingleUserEntity
import com.example.bikeapplication.Entities.UserEntity

@Database(entities = [SingleUserEntity::class, SingleBikeEntity::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun BikeApplicationAPI(): BikeApplicationAPI?


    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "bikeApplicationDatabase.db"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}