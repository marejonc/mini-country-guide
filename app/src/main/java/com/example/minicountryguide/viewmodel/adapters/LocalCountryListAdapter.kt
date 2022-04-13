package com.example.minicountryguide.viewmodel.adapters

import android.content.Context
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.minicountryguide.R
import com.example.minicountryguide.model.utils.CountryList

class LocalCountryListAdapter(private val countryList: LiveData<List<String>>, context: Context):
    RecyclerView.Adapter<LocalCountryListAdapter.LocalCountryListHolder>() {

    private var selectedPosition: Int = RecyclerView.NO_POSITION
    private var lastSelectedPosition: Int = RecyclerView.NO_POSITION
    private val currentContext = context

    inner class LocalCountryListHolder(view: View): RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener {
                selectedPosition = adapterPosition
                if(lastSelectedPosition == -1) lastSelectedPosition = selectedPosition
                else {
                    notifyItemChanged(lastSelectedPosition)
                    lastSelectedPosition = selectedPosition
                }
                notifyItemChanged(selectedPosition)
            }
        }

        val textViewCountryCode = view.findViewById<TextView>(R.id.countryCode_textView)
        val textViewCountryName = view.findViewById<TextView>(R.id.countryName_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalCountryListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_country_in_list, parent, false)
        return LocalCountryListHolder(view)
    }

    override fun onBindViewHolder(holder: LocalCountryListHolder, position: Int) {

        if(currentContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES) {
            if(position == selectedPosition)
                holder.itemView.findViewById<LinearLayout>(R.id.single_country).setBackgroundColor(ContextCompat.getColor(currentContext, R.color.highlight_color))
            else
                holder.itemView.findViewById<LinearLayout>(R.id.single_country).setBackgroundColor(ContextCompat.getColor(currentContext, R.color.dark_gray))
        }
        else {
            if(position == selectedPosition)
                holder.itemView.findViewById<LinearLayout>(R.id.single_country).setBackgroundColor(ContextCompat.getColor(currentContext, R.color.highlight_color))
            else
                holder.itemView.findViewById<LinearLayout>(R.id.single_country).setBackgroundColor(ContextCompat.getColor(currentContext, R.color.white))
        }

        holder.textViewCountryCode.text = countryList.value?.get(position)
        holder.textViewCountryName.text = CountryList.getCountryByCode(countryList.value?.get(position)!!)
    }

    override fun getItemCount() = countryList.value?.size?:0

    fun getSelectedPosition() = selectedPosition
    fun getSelectedCountryCode() = countryList.value?.get(selectedPosition)
}