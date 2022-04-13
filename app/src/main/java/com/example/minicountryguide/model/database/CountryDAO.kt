package com.example.minicountryguide.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.minicountryguide.model.entities.CountryLocal

@Dao
interface CountryDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCountry(country: CountryLocal)

    @Delete suspend fun deleteCountry(country: CountryLocal)

    @Query("delete from country where alpha3 = :alphaCode")
    fun deleteByCode(alphaCode: String)

    @Query("select * from country where alpha3 = :alphaCode")
    fun getCountryData(alphaCode: String): LiveData<CountryLocal>

    @Query("select alpha3 from country order by english_common_name")
    fun getAllCodesInDatabase(): LiveData<List<String>>

    @Query("delete from country")
    suspend fun deleteAllCountries()
}