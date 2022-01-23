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
import com.example.minicountryguide.R
import com.example.minicountryguide.model.utils.Dictionaries
import com.example.minicountryguide.model.utils.Utils
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
                view.findViewById<TextView>(R.id.polishOfficialNameValue_textView).text = viewModel.countryData.value?.translations?.pol?.official
                view.findViewById<TextView>(R.id.englishCommonNameValue_textView).text = viewModel.countryData.value?.name?.common
                view.findViewById<TextView>(R.id.englishOfficialNameValue_textView).text = viewModel.countryData.value?.name?.official
                view.findViewById<TextView>(R.id.capitalValue_textView).text = Utils.printListedData(viewModel.countryData.value?.capital!!)
                view.findViewById<TextView>(R.id.continentValue_textView).text = Dictionaries.findPolishContinentName(viewModel.countryData.value!!.continents[0])
                view.findViewById<TextView>(R.id.alpha2Value_textView).text = viewModel.countryData.value?.cca2
                view.findViewById<TextView>(R.id.alpha3Value_textView).text = viewModel.countryData.value?.cca3
                view.findViewById<TextView>(R.id.alpha3Value_textView).text = viewModel.countryData.value?.cca3
                view.findViewById<TextView>(R.id.neighboursValue_textView).text = Utils.printNeighbours(viewModel.countryData.value?.borders!!)
                view.findViewById<TextView>(R.id.areaValue_textView).text = viewModel.countryData.value?.area.toString()
                view.findViewById<TextView>(R.id.populationValue_textView).text = viewModel.countryData.value?.population.toString()
                view.findViewById<TextView>(R.id.timezonesValue_textView).text = Utils.printListedData(viewModel.countryData.value?.timezones!!)
                view.findViewById<TextView>(R.id.carCodeValue_textView).text = viewModel.countryData.value?.car!!.signs[0]
                view.findViewById<TextView>(R.id.carSideValue_textView).text = Dictionaries.findPolishSide(viewModel.countryData.value?.car!!.side)
            })

        view.findViewById<TextView>(R.id.country_name_textView).text = arguments?.getString("PICKED_COUNTRY_NAME")?.uppercase()
    }
}
