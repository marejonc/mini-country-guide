package com.example.minicountryguide.model.repositories

import com.example.minicountryguide.model.database.CountryDAO
import com.example.minicountryguide.model.entities.CountryLocal

class CountryLocalRepository private constructor(private val countryDAO: CountryDAO) {

    suspend fun addCountry(country: CountryLocal) = countryDAO.insertCountry(country)
    fun getAllCodes() = countryDAO.getAllCodesInDatabase()
    fun getCountryData(code: String) = countryDAO.getCountryData(code)
    fun deleteCountry(code: String) = countryDAO.deleteByCode(code)
    suspend fun deleteAllCountries() = countryDAO.deleteAllCountries()

    companion object {
        @Volatile private var instance: CountryLocalRepository? = null

        fun getInstance(countryDAO: CountryDAO) =
            instance ?: synchronized(this) {
                instance ?: CountryLocalRepository(countryDAO).also { instance = it }
            }
    }
}