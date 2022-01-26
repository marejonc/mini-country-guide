package com.example.minicountryguide.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.minicountryguide.R
import com.example.minicountryguide.model.entities.CountryLocal
import com.example.minicountryguide.model.utils.Dictionaries
import com.example.minicountryguide.model.utils.Utilities
import com.example.minicountryguide.viewmodel.adapters.CountryDataListAdapter
import com.example.minicountryguide.viewmodel.vms.CountryViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

class FragmentPickedCountryFromLocation: Fragment()
{
    private lateinit var viewModel: CountryViewModel
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var geocoder: Geocoder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[CountryViewModel::class.java]
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        geocoder = Geocoder(this.context)
        return inflater.inflate(R.layout.fragment_pickedcountry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) { return }
        else {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                val addresses: List<Address> = geocoder.getFromLocation(location!!.latitude, location.longitude, 1)
                val country = addresses[0].countryCode
                viewModel.getCountryData(country)
                viewModel.countryData.observe(viewLifecycleOwner,
                    {
                        val transformation: Transformation = RoundedTransformationBuilder().cornerRadiusDp(10f).build()
                        Picasso.with(this.context).load(viewModel.countryData.value?.flags?.png).transform(transformation)
                            .memoryPolicy(MemoryPolicy.NO_CACHE).into(view.findViewById<ImageView>(R.id.country_flag_imageView))

                        val commonName = viewModel.countryData.value?.translations?.pol?.common!!
                        val officialName = viewModel.countryData.value?.translations?.pol?.official!!
                        val commonEnglishName = viewModel.countryData.value?.name?.common!!
                        val officialEnglishName = viewModel.countryData.value?.name?.official!!
                        val capital = Utilities.printListedData(viewModel.countryData.value?.capital!!)
                        val continent = Dictionaries.findPolishContinentName(viewModel.countryData.value!!.continents[0])
                        val alpha3 = viewModel.countryData.value?.cca3!!
                        val alpha2 = viewModel.countryData.value?.cca2!!
                        val neighbours = Utilities.printNeighbours(viewModel.countryData.value?.borders!!)
                        val area = viewModel.countryData.value?.area!!
                        val population = viewModel.countryData.value?.population!!
                        val timeZones = Utilities.printListedData(viewModel.countryData.value?.timezones!!)
                        val carSign = viewModel.countryData.value?.car!!.signs[0]
                        val carSide = Dictionaries.findPolishSide(viewModel.countryData.value?.car!!.side)

                        val dataList = arrayListOf(
                            listOf(resources.getString(R.string.official_polish_name_caption), officialName),
                            listOf(resources.getString(R.string.common_english_name_caption), commonEnglishName),
                            listOf(resources.getString(R.string.official_english_name_caption), officialEnglishName),
                            listOf(resources.getString(R.string.capital_caption), capital),
                            listOf(resources.getString(R.string.continent_caption), continent),
                            listOf(resources.getString(R.string.alpha2_code_caption), alpha2),
                            listOf(resources.getString(R.string.alpha3_code_caption), alpha3),
                            listOf(resources.getString(R.string.neighbours_caption), neighbours),
                            listOf(resources.getString(R.string.land_area_caption), area.toString()),
                            listOf(resources.getString(R.string.population_caption), population.toString()),
                            listOf(resources.getString(R.string.time_zones_caption), timeZones),
                            listOf(resources.getString(R.string.car_code_caption), carSign),
                            listOf(resources.getString(R.string.car_side_caption), carSide)
                        )

                        val countryDataListAdapter = CountryDataListAdapter(dataList)

                        view.findViewById<RecyclerView>(R.id.countryData_recycler).let {
                            it.adapter = countryDataListAdapter
                            it.itemAnimator = null
                        }

                        view.findViewById<Button>(R.id.save_locally_button).setOnClickListener {
                            val localCountry = CountryLocal(alpha3, alpha2, commonName, officialName,
                                commonEnglishName, officialEnglishName, continent, capital,
                                neighbours, area, population, timeZones, carSide, carSign)
                            viewModel.addLocalCountry(localCountry)
                        }

                        view.findViewById<TextView>(R.id.country_name_textView).text = commonName.uppercase()
                    })

            }
        }
    }
}