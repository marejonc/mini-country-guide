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
import androidx.recyclerview.widget.RecyclerView
import com.example.minicountryguide.R

class CountryListAdapter(private val countryList: ArrayList<List<String>>, context: Context): RecyclerView.Adapter<CountryListAdapter.CountryListHolder>()
    , Filterable {

    private var filteredCountryList: ArrayList<List<String>> = countryList
    private var selectedPosition: Int = RecyclerView.NO_POSITION
    private var lastSelectedPosition: Int = RecyclerView.NO_POSITION
    private val currentContext = context

    inner class CountryListHolder(view: View): RecyclerView.ViewHolder(view) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_country_in_list, parent, false)
        return CountryListHolder(view)
    }

    override fun onBindViewHolder(holder: CountryListHolder, position: Int) {

        if(currentContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES) {
            if(position == selectedPosition)
                holder.itemView.findViewById<LinearLayout>(R.id.single_country).setBackgroundColor(Color.parseColor("#000000"))
            else
                holder.itemView.findViewById<LinearLayout>(R.id.single_country).setBackgroundColor(Color.parseColor("#121212"))
        }
        else {
            if(position == selectedPosition)
                holder.itemView.findViewById<LinearLayout>(R.id.single_country).setBackgroundColor(Color.parseColor("#E6E6E6"))
            else
                holder.itemView.findViewById<LinearLayout>(R.id.single_country).setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        holder.textViewCountryCode.text = filteredCountryList[position][0]
        holder.textViewCountryName.text = filteredCountryList[position][1]
    }

    override fun getItemCount() = filteredCountryList.size

    override fun getFilter(): Filter {
        return object: Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val searchFilter = constraint.toString()
                if(searchFilter.isEmpty()) filteredCountryList = countryList
                else {
                    val resultList = arrayListOf<List<String>>()
                    for(row in countryList)
                        if(row[1].lowercase().contains(searchFilter, ignoreCase = true))
                            resultList.add(row)
                    filteredCountryList = resultList
                }

                return FilterResults().apply{ values = filteredCountryList }
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                selectedPosition = RecyclerView.NO_POSITION
                lastSelectedPosition = RecyclerView.NO_POSITION

                filteredCountryList = if(results?.values == null) ArrayList()
                else results.values as ArrayList<List<String>>
                notifyDataSetChanged()
            }
        }
    }

    fun getSelectedPosition() = selectedPosition
    fun getSelectedCountryName() = filteredCountryList[selectedPosition][1]
    fun getSelectedCountryCode() = filteredCountryList[selectedPosition][0]
}