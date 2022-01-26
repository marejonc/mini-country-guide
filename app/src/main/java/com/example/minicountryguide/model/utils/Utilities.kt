package com.example.minicountryguide.model.utils

import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.ConnectivityManager
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import java.util.jar.Manifest

object Utilities {
    fun printListedData(data: List<String>): String {
        var result = ""
        for(i in data.indices) {
            result += data[i]
            if(i != data.size - 1) result += " / "
        }
        return result
    }

    fun printNeighbours(data: List<String>): String {
        var result = ""
        val countries = CountryList.getCountries()
        if(data.isEmpty()) result = "Brak"
        else {
            for (i in data.indices)
                for (j in countries.indices)
                    if (countries[j][0] == data[i]) {
                        result += countries[j][1]
                        if (i != data.size - 1) result += " / "
                    }
        }
        return result
    }

    fun isOnline(context: Context?): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) return true
        return false
    }

    fun locationEnabled(context: Context?): Boolean {
        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun checkLocationPermission(context: Context?): Boolean {
        return ActivityCompat.checkSelfPermission(context!!, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED
    }
}