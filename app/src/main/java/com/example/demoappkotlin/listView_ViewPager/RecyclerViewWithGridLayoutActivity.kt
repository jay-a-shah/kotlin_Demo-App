package com.example.demoappkotlin.listView_ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.Adapters.RecyclerGridLayoutAdapter
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelRecycleGridLayout
import com.example.demoappkotlin.utils.TWO

class RecyclerViewWithGridLayoutActivity : AppCompatActivity() {
    lateinit var gridLayoutAdapter: RecyclerGridLayoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_grid_layout)
        var containlist = ArrayList<ModelRecycleGridLayout>()
        gridLayoutAdapter = RecyclerGridLayoutAdapter(containlist)
        val gridRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewGridLayout)
        gridRecyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, TWO)
            adapter = gridLayoutAdapter
        }
        containlist.apply {
            add(ModelRecycleGridLayout(getString(R.string.title_android_expandable_recycler_view), getString(R.string.tab_jay_viewpager_two), R.drawable.android))
            add(ModelRecycleGridLayout(getString(R.string.title_mongodb_expandable_recycler_view), getString(R.string.tab_jay_viewpager_two), R.drawable.mongo))
            add(ModelRecycleGridLayout(getString(R.string.title_larvel_expandable_recycler_view), getString(R.string.tab_jay_viewpager_two), R.drawable.larvel))
            add(ModelRecycleGridLayout(getString(R.string.title_kotlin_expandable_recycler_view), getString(R.string.tab_jay_viewpager_two), R.drawable.kotlin))
            add(ModelRecycleGridLayout(getString(R.string.title_people_recycler_view_with_grid_layout), getString(R.string.tab_jay_viewpager_two), R.drawable.ic_baseline_person_24))
        }
    }
}