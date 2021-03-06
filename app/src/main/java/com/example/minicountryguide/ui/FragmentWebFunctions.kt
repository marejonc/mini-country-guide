package com.example.minicountryguide.ui

import android.Manifest
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.minicountryguide.R
import com.example.minicountryguide.model.utils.Utilities

private const val NO_LOCATION_SERVICE_ALERT = "Network or location error"
private const val LOCATION_PERMISSION_DENIED_ALERT = "Give access to location services"

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

        view.findViewById<Button>(R.id.homeLocation_button).setOnClickListener {
            if(!Utilities.checkLocationPermission(requireContext())) {
                ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 101)
                Toast.makeText(context, LOCATION_PERMISSION_DENIED_ALERT, Toast.LENGTH_SHORT).show()
            }
            else {
                if(Utilities.locationEnabled(requireContext()) && Utilities.isOnline(requireContext()))
                    it.findNavController().navigate(R.id.action_fragmentWebFunctions_to_fragmentPickedCountryFromLocation)
                else Toast.makeText(context, NO_LOCATION_SERVICE_ALERT, Toast.LENGTH_SHORT).show() }
            }

        view.findViewById<Button>(R.id.homeSearch_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentWebFunctions_to_fragmentCountryList) }
    }
}