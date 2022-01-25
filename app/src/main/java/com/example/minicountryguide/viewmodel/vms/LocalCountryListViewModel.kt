package com.example.minicountryguide.viewmodel.vms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.minicountryguide.model.database.CountryGuideDatabase
import com.example.minicountryguide.model.repositories.CountryLocalRepository

class LocalCountryListViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CountryLocalRepository.getInstance(CountryGuideDatabase.getInstance(application).countryDAO)
    val countries: LiveData<List<String>> = repository.getAllCodes()
}