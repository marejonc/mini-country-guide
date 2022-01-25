package com.example.minicountryguide.ui

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.minicountryguide.R
import com.example.minicountryguide.model.utils.Utilities

private const val NO_LOCATION_SERVICE_ALERT = "Błąd sieci lub lokalizacji"
private const val LOCATION_PERMISSION_DENIED_ALERT = "Nadaj prawo do odbierania lokalizacji"

class FragmentWebFunctions: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web_functions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    view.findViewById<Button>(R.id.homeLocation_button).setOnClickListener{
                        if(Utilities.locationEnabled(requireContext()) && Utilities.isOnline(requireContext()))
                            it.findNavController().navigate(R.id.action_fragmentWebFunctions_to_fragmentPickedCountryFromLocation)
                        else Toast.makeText(context, NO_LOCATION_SERVICE_ALERT, Toast.LENGTH_SHORT).show() }
                }
                else -> { Toast.makeText(context, LOCATION_PERMISSION_DENIED_ALERT, Toast.LENGTH_SHORT).show() }
            }
        }

        locationPermissionRequest.launch(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION))

        view.findViewById<Button>(R.id.homeSearch_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentWebFunctions_to_fragmentCountryList) }
    }
}