package com.example.minicountryguide.viewmodel.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minicountryguide.R

class CountryDataListAdapter(private val dataList: ArrayList<List<String>>): RecyclerView.Adapter<CountryDataListAdapter.CountryDataListHolder>() {

    inner class CountryDataListHolder(view: View): RecyclerView.ViewHolder(view) {
        val textViewFieldCaption = view.findViewById<TextView>(R.id.singleDataFieldCaption_textView)
        val textViewFieldValue = view.findViewById<TextView>(R.id.singleDataFieldValue_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryDataListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_country_data_field, parent, false)
        return CountryDataListHolder(view)
    }

    override fun onBindViewHolder(holder: CountryDataListHolder, position: Int) {
        holder.textViewFieldCaption.text = dataList[position][0]
        holder.textViewFieldValue.text = dataList[position][1]
    }

    override fun getItemCount() = dataList.size
}