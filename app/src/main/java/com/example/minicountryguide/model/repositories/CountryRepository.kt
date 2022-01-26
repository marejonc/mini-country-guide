package com.example.minicountryguide.model.repositories

import com.example.minicountryguide.model.entities.Country
import com.example.minicountryguide.model.retrofit.RetrofitInstance
import retrofit2.awaitResponse

class CountryRepository {

    suspend fun getCountryData(code: String): Country? {
        return RetrofitInstance.api.getCountryData(code).awaitResponse().body()
    }
}