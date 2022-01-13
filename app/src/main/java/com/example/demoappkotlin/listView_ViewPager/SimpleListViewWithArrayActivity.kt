package com.example.demoappkotlin.listView_ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.demoappkotlin.R

class SimpleListViewWithArrayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_with_array)
        val arrayAdapter:ArrayAdapter<*>
        val users = arrayOf("Android","Kotlin","IOS","Swift","Mongo DB","React","React Native","a","b","c",
            "Android","Kotlin","IOS","Swift","Mongo DB","React","Android","Kotlin","IOS","Swift","Mongo DB","React")
        var listView = findViewById<ListView>(R.id.list_view2)
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,users)
        listView.adapter = arrayAdapter
    }
}