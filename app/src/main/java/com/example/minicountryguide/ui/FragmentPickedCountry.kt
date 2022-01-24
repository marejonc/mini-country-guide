package com.example.minicountryguide.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.minicountryguide.R
import com.example.minicountryguide.model.entities.Country
import com.example.minicountryguide.model.utils.Dictionaries
import com.example.minicountryguide.model.utils.Utils
import com.example.minicountryguide.viewmodel.adapters.CountryDataListAdapter
import com.example.minicountryguide.viewmodel.vms.CountryViewModel
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

class FragmentPickedCountry: Fragment()
{
    private lateinit var viewModel: CountryViewModel

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

        viewModel.countryData.observe(viewLifecycleOwner,
            {
                val transformation: Transformation = RoundedTransformationBuilder().cornerRadiusDp(10f).build()
                Picasso.with(this.context).load(viewModel.countryData.value?.flags?.png).transform(transformation)
                    .memoryPolicy(MemoryPolicy.NO_CACHE).into(view.findViewById<ImageView>(R.id.country_flag_imageView))

                val dataList = arrayListOf(
                    listOf(resources.getString(R.string.official_polish_name_caption), viewModel.countryData.value?.translations?.pol?.official!!),
                    listOf(resources.getString(R.string.common_english_name_caption), viewModel.countryData.value?.name?.common!!),
                    listOf(resources.getString(R.string.official_english_name_caption), viewModel.countryData.value?.name?.official!!),
                    listOf(resources.getString(R.string.capital_caption), Utils.printListedData(viewModel.countryData.value?.capital!!)),
                    listOf(resources.getString(R.string.continent_caption), Dictionaries.findPolishContinentName(viewModel.countryData.value!!.continents[0])),
                    listOf(resources.getString(R.string.alpha2_code_caption), viewModel.countryData.value?.cca2!!),
                    listOf(resources.getString(R.string.alpha3_code_caption), viewModel.countryData.value?.cca3!!),
                    listOf(resources.getString(R.string.neighbours_caption), Utils.printNeighbours(viewModel.countryData.value?.borders!!)),
                    listOf(resources.getString(R.string.land_area_caption), viewModel.countryData.value?.area.toString()),
                    listOf(resources.getString(R.string.population_caption), viewModel.countryData.value?.population.toString()),
                    listOf(resources.getString(R.string.time_zones_caption), Utils.printListedData(viewModel.countryData.value?.timezones!!)),
                    listOf(resources.getString(R.string.car_code_caption), viewModel.countryData.value?.car!!.signs[0]),
                    listOf(resources.getString(R.string.car_side_caption), Dictionaries.findPolishSide(viewModel.countryData.value?.car!!.side))
                )

                val countryDataListAdapter = CountryDataListAdapter(dataList)

                view.findViewById<RecyclerView>(R.id.countryData_recycler).let {
                    it.adapter = countryDataListAdapter
                    it.itemAnimator = null
                }
            })

        view.findViewById<TextView>(R.id.country_name_textView).text = arguments?.getString("PICKED_COUNTRY_NAME")?.uppercase()
    }
}
