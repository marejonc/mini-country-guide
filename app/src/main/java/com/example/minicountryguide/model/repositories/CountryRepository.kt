package com.example.minicountryguide.model.repositories

import android.content.Context
import android.widget.Toast
import com.example.minicountryguide.model.entities.*
import com.example.minicountryguide.model.retrofit.RetrofitInstance
import retrofit2.awaitResponse
import kotlin.coroutines.coroutineContext

private const val EMPTY_IMAGE_SOURCE = "https://upload.wikimedia.org/wikipedia/en/4/48/Blank.JPG"
private const val JSON_ERROR_ALERT = "Błąd formatu JSON"

class CountryRepository {

    suspend fun getCountryData(code: String, context: Context): Country? {
        var result: Country? = Country(Translation(Name("", "")), Name("", ""),
        Flag(EMPTY_IMAGE_SOURCE, EMPTY_IMAGE_SOURCE),
        listOf(""), listOf(""), "", "", listOf(""), 0.0, 0,
        listOf(""), Car(listOf(""), ""))
        try {
            result = RetrofitInstance.api.getCountryData(code).awaitResponse().body()
        }
        catch(e: Exception) {
            Toast.makeText(context, JSON_ERROR_ALERT, Toast.LENGTH_SHORT).show()
        }
        return result
    }
}