package com.example.minicountryguide.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.minicountryguide.R
import com.example.minicountryguide.viewmodel.vms.CountryViewModel
import com.squareup.picasso.Picasso

class FragmentPickedCountry(): Fragment()
{
    lateinit var viewModel: CountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[CountryViewModel::class.java]
        viewModel.getCountryData(arguments?.getString("PICKED_COUNTRY_CODE")!!)
        return inflater.inflate(R.layout.fragment_pickedcountry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(context, viewModel.countryData.value?.flags?.png, Toast.LENGTH_SHORT).show()
        Picasso.with(this.context).load(viewModel.countryData.value?.flags?.png).into(view.findViewById<ImageView>(R.id.country_flag_imageView))
        view.findViewById<TextView>(R.id.country_name_textView).text = arguments?.getString("PICKED_COUNTRY_NAME")
    }
}
