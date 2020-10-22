package com.e.myrecyclerview_int

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1
        val recycler = findViewById<RecyclerView>(R.id.recycler_view)

        //2
        // connect recycler to Adapter and to LinearLayoutManager
        val adapter0 = MyAdapter()

        recycler.adapter = adapter0
        recycler.layoutManager = LinearLayoutManager(application)
    }
}