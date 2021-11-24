package com.example.minicountryguide.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.minicountryguide.R

class HomeFragment(): Fragment()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
            requireActivity().supportFragmentManager.beginTransaction().
            addToBackStack(null).replace(R.id.fragmentLayout, CountryListFragment()).commit()
        }

        view.findViewById<Button>(R.id.homeLocationButton).setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().
            addToBackStack(null).replace(R.id.fragmentLayout, PickedCountryFragment()).commit()
        }

        view.findViewById<Button>(R.id.homeSettingsButton).setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().
            addToBackStack(null).replace(R.id.fragmentLayout, SettingsFragment()).commit()
        }
    }
}