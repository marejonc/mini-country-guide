package com.example.minicountryguide.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.minicountryguide.R

class FragmentHome(): Fragment()
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

        view.findViewById<Button>(R.id.homeSearchButton).setOnClickListener{
            it.findNavController().navigate(R.id.action_fragmentHome_to_fragmentCountryList)
        }

        view.findViewById<Button>(R.id.homeLocationButton).setOnClickListener{
            it.findNavController().navigate(R.id.action_fragmentHome_to_fragmentPickedCountry)
        }

        view.findViewById<Button>(R.id.homeSettingsButton).setOnClickListener{
            it.findNavController().navigate(R.id.action_fragmentHome_to_fragmentSettings)
        }
    }
}