package com.example.demoappkotlin.listView_ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.Adapters.ExpandableRecyclerViewAdapter
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelExpandableRecyclerView

class ExpandableRecyclerViewActivity : AppCompatActivity() {
    lateinit var myExpandableRecyclerAdapter: ExpandableRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_recycler_view)
        var containList = ArrayList<ModelExpandableRecyclerView>()
        myExpandableRecyclerAdapter = ExpandableRecyclerViewAdapter(containList)
        val expandableRecyclerView = findViewById<RecyclerView>(R.id.expandableRecyclerViewLayout)
        expandableRecyclerView.layoutManager = LinearLayoutManager(this)
        containList.apply {
            add(
                ModelExpandableRecyclerView(
                    R.drawable.android,
                    "Android",
                    "Java is an Object Oriented Programming language. Java is used in all kind of applications like Mobile Applications (Android is Java based) desktop applications, web applications, client server applications, enterprise applications and many more.",
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.larvel,
                    "larvel",
                    "Java is an Object Oriented Programming language. Java is used in all kind of applications like Mobile Applications (Android is Java based) desktop applications, web applications, client server applications, enterprise applications and many more.",
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.mongo,
                    "Mongo DB",
                    "Java is an Object Oriented Programming language. Java is used in all kind of applications like Mobile Applications (Android is Java based) desktop applications, web applications, client server applications, enterprise applications and many more.",
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.swift,
                    "Swift",
                    "Java is an Object Oriented Programming language. Java is used in all kind of applications like Mobile Applications (Android is Java based) desktop applications, web applications, client server applications, enterprise applications and many more.",
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.kotlin,
                    "Kotlin",
                    "Java is an Object Oriented Programming language. Java is used in all kind of applications like Mobile Applications (Android is Java based) desktop applications, web applications, client server applications, enterprise applications and many more.",
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.kotlin,
                    "Kotlin",
                    "Java is an Object Oriented Programming language. Java is used in all kind of applications like Mobile Applications (Android is Java based) desktop applications, web applications, client server applications, enterprise applications and many more.",
                    false
                )
            )
        }
        expandableRecyclerView.adapter = myExpandableRecyclerAdapter
    }
}