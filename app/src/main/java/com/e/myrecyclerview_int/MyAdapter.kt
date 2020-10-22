package com.e.myrecyclerview_int

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// adapter get a lambda expression in the constructor
class MyAdapter (val lambda: (String) -> Int  /*, val tmp: Double*/): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


   // val countries = listOf<String>()
    // mutableListOf can be changed, ListOf can not be changed
    val countries = mutableListOf("Israel", "USA", "England")
    val cities = mutableListOf("Jerusalem", "Washington", "London")


    // creating viewHolder
    // creating UI structure for the data, for a single row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        // building View from xml
        val view = layoutInflater.inflate(R.layout.row, parent, false)

        // buliding view holder
        return ViewHolder(view)
    }

    // put the data inside the viewHolder
    // position - the position of the row to show to the user
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        val city = cities[position]

        holder.country.text = country

        val cityView = holder.city
        cityView.text = city

        holder.parent.setOnClickListener(View.OnClickListener {
            lambda(country)
        })
    }

    // total items we want to show
    override fun getItemCount(): Int {
        return countries.size
    }

    fun add(county: String, city: String) {
        countries.add(county)
        cities.add(city)

        // refresh the adapter
        notifyDataSetChanged()
    }

    // itemView is the graphic parent of the row
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val country: TextView = itemView.findViewById(R.id.row_country)
        val city: TextView = itemView.findViewById(R.id.row_city)

        // adding in order to add to it click event
        val parent: View = itemView.findViewById(R.id.row_parent)
    }


}