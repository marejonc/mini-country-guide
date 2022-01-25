package com.example.minicountryguide.ui

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.minicountryguide.R
import com.example.minicountryguide.model.utils.Utilities

private const val NO_NETWORK_ALERT = "Błąd sieci"

class FragmentHome: Fragment()
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

        view.findViewById<Button>(R.id.homeWeb_button).setOnClickListener{
            if(Utilities.isOnline(requireContext()))
                it.findNavController().navigate(R.id.action_fragmentHome_to_fragmentWebFunctions)
            else Toast.makeText(context, NO_NETWORK_ALERT, Toast.LENGTH_SHORT).show() }

        view.findViewById<Button>(R.id.homeLocal_button).setOnClickListener{
            it.findNavController().navigate(R.id.action_fragmentHome_to_fragmentLocalFunctions)
        }
    }
}