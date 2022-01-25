package com.example.minicountryguide.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.minicountryguide.model.entities.CountryLocal

@Database(entities = [CountryLocal::class], version = 1, exportSchema = false)
abstract class CountryGuideDatabase: RoomDatabase() {

    //DAOs
    abstract val countryDAO: CountryDAO

    companion object {
        @Volatile
        private var INSTANCE: CountryGuideDatabase? = null

        fun getInstance(context: Context): CountryGuideDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CountryGuideDatabase::class.java,
                        "teacher_helper_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}