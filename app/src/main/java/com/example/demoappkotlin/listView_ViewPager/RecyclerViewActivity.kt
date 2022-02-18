package com.example.demoappkotlin.listView_ViewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.Adapters.RecycleAdapter
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelRecycle

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var myRecyclerAdapter: RecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        var containList = ArrayList<ModelRecycle>()
        myRecyclerAdapter = RecycleAdapter(containList)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewLayout)
        recyclerView.layoutManager = LinearLayoutManager(this)
        containList.apply {
            add(ModelRecycle("Android", R.drawable.android, false))
            add(ModelRecycle("Kotlin", R.drawable.kotlin, false))
            add(ModelRecycle("larvel", R.drawable.larvel, false))
            add(ModelRecycle("Android", R.drawable.android, false))
            add(ModelRecycle("Kotlin", R.drawable.kotlin, false))
            add(ModelRecycle("larvel", R.drawable.larvel, false))
            add(ModelRecycle("Android", R.drawable.android, false))
            add(ModelRecycle("Kotlin", R.drawable.kotlin, false))
            add(ModelRecycle("larvel", R.drawable.larvel, false))
            add(ModelRecycle("Android", R.drawable.android, false))
            add(ModelRecycle("Kotlin", R.drawable.kotlin, false))
            add(ModelRecycle("larvel", R.drawable.larvel, false))
        }
        recyclerView.apply { addItemDecoration(DividerItemDecoration(baseContext, (recyclerView.layoutManager as LinearLayoutManager).orientation))
            adapter = myRecyclerAdapter
        }
    }
}