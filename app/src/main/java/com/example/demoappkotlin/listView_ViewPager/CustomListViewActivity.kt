package com.example.demoappkotlin.listView_ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.Adapters.MyAdapter
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelList

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
        val listview = findViewById<ListView>(R.id.customlistview)
        listview.adapter = myAdapter
        var new = myAdapter.getItemId(2)
        Toast.makeText(this, "You selected ${new.toLong()}", Toast.LENGTH_SHORT).show()
    }
}