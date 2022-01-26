package com.example.minicountryguide.model.retrofit

import com.example.minicountryguide.model.entities.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryAPI {

    @GET("{code}?fields=translations,name,flags,continents,capital,cca2,cca3,borders,area,population,timezones,car")
    fun getCountryData(@Path("code") code: String): Call<Country>
}