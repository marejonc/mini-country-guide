package com.example.minicountryguide.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.minicountryguide.R
import com.example.minicountryguide.model.utils.CountryList
import com.example.minicountryguide.viewmodel.adapters.CountryListAdapter

class FragmentCountryList: Fragment() {

    private lateinit var countryListAdapter: CountryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        countryListAdapter = CountryListAdapter(CountryList.getCountries(), requireContext())
        return inflater.inflate(R.layout.fragment_countrylist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<SearchView>(R.id.countryList_searchView).setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                countryListAdapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(filterQuery: String?): Boolean {
                countryListAdapter.filter.filter(filterQuery)
                return false
            }
        })

        view.findViewById<RecyclerView>(R.id.countryList_recycler).let {
            it.adapter = countryListAdapter
            it.itemAnimator = null
        }

        view.findViewById<Button>(R.id.searchCountry_button).setOnClickListener {
            if(countryListAdapter.getSelectedPosition() != -1) {
                it.findNavController().navigate(R.id.action_fragmentCountryList_to_fragmentPickedCountry, bundleOf(
                    "PICKED_COUNTRY_CODE" to countryListAdapter.getSelectedCountryCode(),
                    "PICKED_COUNTRY_NAME" to countryListAdapter.getSelectedCountryName()
                ))
                view.findViewById<SearchView>(R.id.countryList_searchView).setQuery("", false)
            }
        }
    }
}