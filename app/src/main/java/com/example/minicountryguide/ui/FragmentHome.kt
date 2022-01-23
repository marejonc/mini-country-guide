package com.example.minicountryguide.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.minicountryguide.R
import com.example.minicountryguide.model.utils.Utils

private const val NO_NETWORK_ALERT = "Błąd internetu lub lokalizacji"
private const val LOCATION_PERMISSION_DENIED_ALERT = "Nadaj prawo do odbierania lokalizacji"

class FragmentHome: Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    view.findViewById<Button>(R.id.homeLocationButton).setOnClickListener{
                        if(Utils.locationEnabled(requireContext()) && Utils.isOnline(requireContext()))
                            it.findNavController().navigate(R.id.action_fragmentHome_to_fragmentPickedCountryFromLocation)
                        else Toast.makeText(context, NO_NETWORK_ALERT, Toast.LENGTH_SHORT).show() }
                }
                else -> {
                    Toast.makeText(context, LOCATION_PERMISSION_DENIED_ALERT, Toast.LENGTH_SHORT).show()
                }
            }

        }

        locationPermissionRequest.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION))

        view.findViewById<Button>(R.id.homeSearchButton).setOnClickListener{
            if(Utils.isOnline(requireContext())) it.findNavController().navigate(R.id.action_fragmentHome_to_fragmentCountryList)
            else Toast.makeText(context, NO_NETWORK_ALERT, Toast.LENGTH_SHORT).show() }

        view.findViewById<Button>(R.id.homeSettingsButton).setOnClickListener{
            it.findNavController().navigate(R.id.action_fragmentHome_to_fragmentLocalCountryList)
        }
    }
}