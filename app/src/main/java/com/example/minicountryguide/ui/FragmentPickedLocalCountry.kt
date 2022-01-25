package com.example.minicountryguide.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.minicountryguide.R
import com.example.minicountryguide.model.entities.Country
import com.example.minicountryguide.model.entities.CountryLocal
import com.example.minicountryguide.model.utils.Dictionaries
import com.example.minicountryguide.model.utils.Utilities
import com.example.minicountryguide.viewmodel.adapters.CountryDataListAdapter
import com.example.minicountryguide.viewmodel.vms.LocalCountryViewModel

private const val DELETED_LOCALLY_ALERT = "Usunięto z lokalnej bazy danych"

class FragmentPickedLocalCountry: Fragment() {

    private lateinit var viewModel: LocalCountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[LocalCountryViewModel::class.java]
        viewModel.setCountryCode(arguments?.getString("LOCAL_PICKED_COUNTRY_CODE")!!)
        return inflater.inflate(R.layout.fragment_pickedcountry_local, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.countryData.observe(viewLifecycleOwner,
            {
                val commonName = viewModel.countryData.value?.polishCommonName!!
                val officialName = viewModel.countryData.value?.polishOfficialName!!
                val commonEnglishName = viewModel.countryData.value?.englishCommonName!!
                val officialEnglishName = viewModel.countryData.value?.englishOfficialName!!
                val capital = viewModel.countryData.value?.capital!!
                val continent = viewModel.countryData.value?.continent!!
                val alpha3 = viewModel.countryData.value?.cca3!!
                val alpha2 = viewModel.countryData.value?.cca2!!
                val neighbours = viewModel.countryData.value?.neighbours!!
                val area = viewModel.countryData.value?.area!!
                val population = viewModel.countryData.value?.population!!
                val timeZones = viewModel.countryData.value?.timezones!!
                val carSign = viewModel.countryData.value?.carCode!!
                val carSide = viewModel.countryData.value?.carSide!!

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

                view.findViewById<RecyclerView>(R.id.localCountryData_recycler).let {
                    it.adapter = countryDataListAdapter
                    it.itemAnimator = null
                }

                view.findViewById<TextView>(R.id.localCountry_name_textView).text = commonName.uppercase()

                view.findViewById<Button>(R.id.delete_locally_button).setOnClickListener {
                    it.findNavController().navigate(R.id.action_fragmentPickedLocalCountry_to_fragmentLocalCountryList)
                    viewModel.deleteLocalCountry(viewModel.countryData.value?.cca3!!)
                    Toast.makeText(context, DELETED_LOCALLY_ALERT, Toast.LENGTH_SHORT).show()
                }
            })

    }
}