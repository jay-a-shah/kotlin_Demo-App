package com.example.demoappkotlin.listviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.Adapters.RecycleAdapter
import com.example.demoappkotlin.listviewpager.modelclasses.ModelRecycle

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var myRecyclerAdapter: RecycleAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var horizontalRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val searchView = findViewById<SearchView>(R.id.searchBar)
        recyclerView = findViewById(R.id.recyclerViewLayout)
        horizontalRecyclerView = findViewById(R.id.horizontalRecyclerView)
        var containList = ArrayList<ModelRecycle>()
        var filterArrayList = ArrayList<ModelRecycle>()
        filterArrayList.addAll(containList)
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
        setAdapter(containList)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterArrayList.clear()
                if (newText?.lowercase()?.isNotEmpty() == true) {
                    var list = containList.filter {
                        it.name.lowercase().contains(newText.toString())
                    } as ArrayList<ModelRecycle>
                    filterArrayList.addAll(list)
                    setAdapter((filterArrayList))
                } else {
                    filterArrayList.apply {
                        clear()
                        addAll(containList)
                    }
                    setAdapter(filterArrayList)
                }
                return false
            }
        })
    }

    private fun setAdapter(arrayList: ArrayList<ModelRecycle>) {
        myRecyclerAdapter = RecycleAdapter(arrayList)
        recyclerView.apply {
            addItemDecoration(
                DividerItemDecoration(
                    baseContext,
                    (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
            adapter = myRecyclerAdapter
        }
        horizontalRecyclerView.adapter = myRecyclerAdapter
    }
}