package com.example.demoappkotlin.listviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.Adapters.ExpandableRecyclerViewAdapter
import com.example.demoappkotlin.listviewpager.modelclasses.ModelExpandableRecyclerView

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
                    getString(R.string.title_android_expandable_recycler_view),
                    getString(R.string.desc_android_expandable_recycler_view),
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.larvel,
                    getString(R.string.title_larvel_expandable_recycler_view),
                    getString(R.string.desc_android_expandable_recycler_view),
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.mongo,
                    getString(R.string.title_mongodb_expandable_recycler_view),
                    getString(R.string.desc_android_expandable_recycler_view),
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.swift,
                    getString(R.string.title_swift_expandable_recycler_view),
                    getString(R.string.desc_android_expandable_recycler_view),
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.kotlin,
                    getString(R.string.title_kotlin_expandable_recycler_view),
                    getString(R.string.desc_android_expandable_recycler_view),
                    false
                )
            )
            add(
                ModelExpandableRecyclerView(
                    R.drawable.kotlin,
                    getString(R.string.title_kotlin_expandable_recycler_view),
                    getString(R.string.desc_android_expandable_recycler_view),
                    false
                )
            )
        }
        expandableRecyclerView.adapter = myExpandableRecyclerAdapter
    }
}