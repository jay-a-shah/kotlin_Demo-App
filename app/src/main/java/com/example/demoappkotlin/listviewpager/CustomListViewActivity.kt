package com.example.demoappkotlin.listviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.Adapters.MyAdapter
import com.example.demoappkotlin.listviewpager.modelclasses.ModelList
import com.example.demoappkotlin.utils.TWO

class CustomListViewActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)
        val list = ArrayList<ModelList>()
        myAdapter = MyAdapter(this, list)
        list.apply {
            add(ModelList("Android", "A", R.drawable.android))
            add(ModelList("Kotlin", "k", R.drawable.kotlin))
            add(ModelList("Swift", "S", R.drawable.swift))
            add(ModelList("React", "R", R.drawable.larvel))
            add(ModelList("Mongo", "M", R.drawable.mongo))
        }
        val listView = findViewById<ListView>(R.id.customListView)
        listView.adapter = myAdapter
        var new = myAdapter.getItemId(TWO)
        Toast.makeText(this, "You selected ${new.toLong()}", Toast.LENGTH_SHORT).show()
    }
}