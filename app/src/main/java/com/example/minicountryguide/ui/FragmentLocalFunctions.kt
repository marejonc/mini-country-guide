package com.example.minicountryguide.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.minicountryguide.R
import com.example.minicountryguide.viewmodel.vms.LocalCountryViewModel

private const val DELETE_DATA_ALERT = "Zresetowano lokalną bazę danych"

class FragmentLocalFunctions: Fragment() {

    private lateinit var viewModel: LocalCountryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[LocalCountryViewModel::class.java]
        return inflater.inflate(R.layout.fragment_local_functions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.homeLocalData_button).setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentLocalFunctions_to_fragmentLocalCountryList)
        }

        view.findViewById<Button>(R.id.homeReset_button).setOnClickListener {
            Toast.makeText(context, DELETE_DATA_ALERT, Toast.LENGTH_SHORT).show()
            viewModel.deleteAllData()
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                view.findNavController().navigate(R.id.action_fragmentLocalFunctions_to_fragmentHome)
            }
        })
    }
}