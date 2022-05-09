package com.example.minicountryguide.model.restServices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val REST_COUNTRIES_BASE_URL = "https://restcountries.com/v3.1/alpha/"
private const val REST_UNESCO_BASE_URL = "https://examples.opendatasoft.com/api/records/1.0/search/?dataset=world-heritage-unesco-list"

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(REST_COUNTRIES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val countryAPI: CountryAPI by lazy {
        Retrofit.Builder()
            .baseUrl(REST_COUNTRIES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryAPI::class.java)
    }

    val unescoAPI: UnescoAPI by lazy {
        Retrofit.Builder()
            .baseUrl(REST_UNESCO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UnescoAPI::class.java)
    }
}