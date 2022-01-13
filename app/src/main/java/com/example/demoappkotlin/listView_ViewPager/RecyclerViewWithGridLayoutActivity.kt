package com.example.demoappkotlin.listView_ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.Adapters.RecyclerGridLayoutAdapter
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelRecycleGridLayout

class RecyclerViewWithGridLayoutActivity : AppCompatActivity() {
    lateinit var gridLayoutAdapter: RecyclerGridLayoutAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_grid_layout)
        var containlist = ArrayList<ModelRecycleGridLayout>()
        gridLayoutAdapter = RecyclerGridLayoutAdapter(containlist)
        val gridRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewGridLayout)
        gridRecyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        gridRecyclerView.adapter = gridLayoutAdapter
        containlist.apply {
            add(ModelRecycleGridLayout("Android", "Jay", R.drawable.android))
            add(ModelRecycleGridLayout("Mongo", "Jay", R.drawable.mongo))
            add(ModelRecycleGridLayout("Larvel", "Jay", R.drawable.larvel))
            add(ModelRecycleGridLayout("Kotlin", "Jay", R.drawable.kotlin))
            add(ModelRecycleGridLayout("People", "Jay", R.drawable.ic_baseline_person_24))
        }
    }
}