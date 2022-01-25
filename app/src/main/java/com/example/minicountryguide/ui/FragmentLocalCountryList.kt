package com.example.minicountryguide.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.minicountryguide.R
import com.example.minicountryguide.viewmodel.adapters.LocalCountryListAdapter
import com.example.minicountryguide.viewmodel.vms.LocalCountryListViewModel
import com.example.minicountryguide.viewmodel.vms.LocalCountryViewModel

private const val PICK_ELEMENT_OF_LIST_ALERT = "Wybierz element z listy"

class FragmentLocalCountryList: Fragment() {

    private lateinit var viewModel: LocalCountryListViewModel
    private lateinit var localCountryListAdapter: LocalCountryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[LocalCountryListViewModel::class.java]
        localCountryListAdapter = LocalCountryListAdapter(viewModel.countries, requireContext())
        return inflater.inflate(R.layout.fragment_countrylist_local, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.countries.observe(viewLifecycleOwner, {localCountryListAdapter.notifyDataSetChanged()})

        view.findViewById<RecyclerView>(R.id.localCountryList_recycler).let {
            it.adapter = localCountryListAdapter
            it.itemAnimator = null
        }

        view.findViewById<Button>(R.id.pickLocalCountry_button).setOnClickListener {
            if(localCountryListAdapter.getSelectedPosition() != -1) {
                it.findNavController().navigate(R.id.action_fragmentLocalCountryList_to_fragmentPickedLocalCountry, bundleOf(
                    "LOCAL_PICKED_COUNTRY_CODE" to localCountryListAdapter.getSelectedCountryCode()))
            }
            else Toast.makeText(context, PICK_ELEMENT_OF_LIST_ALERT, Toast.LENGTH_SHORT).show()
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
           override fun handleOnBackPressed() {
                view.findNavController().navigate(R.id.action_fragmentLocalCountryList_to_fragmentLocalFunctions)
            }
        })
    }
}