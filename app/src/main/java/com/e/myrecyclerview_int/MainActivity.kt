package com.e.myrecyclerview_int

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1
        val recycler = findViewById<RecyclerView>(R.id.recycler_view)


        var lambdafunction = { str: String ->
                // returns the expression below
                Log.d("TAG", str)
        }

        //2
        // connect recycler to Adapter and to LinearLayoutManager
        val adapter0 = MyAdapter(lambdafunction)

        recycler.adapter = adapter0
        recycler.layoutManager = LinearLayoutManager(application)


        val countryEdit = findViewById<EditText>(R.id.editTextCountry)
        val cityEdit = findViewById<EditText>(R.id.editTextCity)
        val buttonAdd = findViewById<View>(R.id.button_add)

        buttonAdd.setOnClickListener(View.OnClickListener {
            val county = countryEdit.text.toString()
            val city = cityEdit.text.toString()

            adapter0.add(county, city)
        })

    }
}


//
//task
        // print Log on a click on a city, with the city name