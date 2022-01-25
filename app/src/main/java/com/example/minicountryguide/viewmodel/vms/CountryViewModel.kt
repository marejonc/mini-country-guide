package com.example.minicountryguide.viewmodel.vms

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.minicountryguide.model.database.CountryGuideDatabase
import com.example.minicountryguide.model.entities.Country
import com.example.minicountryguide.model.entities.CountryLocal
import com.example.minicountryguide.model.repositories.CountryLocalRepository
import com.example.minicountryguide.model.repositories.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CountryRepository()
    private val localRepository = CountryLocalRepository.getInstance(CountryGuideDatabase.getInstance(application).countryDAO)

    private val _countryData: MutableLiveData<Country> = MutableLiveData()
    val countryData: LiveData<Country>
        get() { return _countryData }

    fun getCountryData(code: String) {
        viewModelScope.launch {
            _countryData.value = repository.getCountryData(code)
        }
    }

    fun addLocalCountry(country: CountryLocal) {
        viewModelScope.launch(Dispatchers.IO) {
            localRepository.addCountry(country)
        }
    }
}