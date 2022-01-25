package com.example.minicountryguide.viewmodel.vms

import android.app.Application
import androidx.lifecycle.*
import com.example.minicountryguide.model.database.CountryGuideDatabase
import com.example.minicountryguide.model.entities.CountryLocal
import com.example.minicountryguide.model.repositories.CountryLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalCountryViewModel(application: Application): AndroidViewModel(application) {

    private val repository = CountryLocalRepository.getInstance(CountryGuideDatabase.getInstance(application).countryDAO)
    private val _countryCode = MutableLiveData<String>()
    val countryData: LiveData<CountryLocal> = Transformations.switchMap(_countryCode) { code -> repository.getCountryData(code)}

    fun setCountryCode(code: String) { _countryCode.value = code }

    fun deleteLocalCountry(code: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCountry(code)
        }
    }

    fun deleteAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCountries()
        }
    }
}