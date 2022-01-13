package com.example.demoappkotlin.listView_ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.Adapters.ExpandableListViewAdapter

class ExpandableListViewActivity : AppCompatActivity() {
    lateinit var expandableListView: ExpandableListView
    var header: MutableList<String> = ArrayList()
    var body: HashMap<String, List<String>> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_list_view)
        expandableListView = findViewById(R.id.expandableListView)
        val plants: MutableList<String> = ArrayList()
        val fruits: MutableList<String> = ArrayList()
        val vegetables: MutableList<String> = ArrayList()
        plants.apply {
            add("Jasmine")
            add("Mogra")
            add("Tulsi")
            add("Office Flowers")
            add("Raat Raani")
        }
        fruits.apply {
            add("Apple")
            add("Banana")
            add("Grapes")
            add("Kiwi")
            add("Dragon fruit")
        }
        vegetables.apply {
            add("Tomato")
            add("Cabbage")
        }
        header.apply {
            add("fruits")
            add("Vegetables")
            add("Plants")
            add("Vegetables")
            add("Plants")
            add("fruits")
        }
        body[header[0]] = fruits
        body[header[1]] = vegetables
        body[header[2]] = plants
        body[header[3]] = vegetables
        body[header[4]] = plants
        body[header[5]] = fruits
        expandableListView.setAdapter(ExpandableListViewAdapter(this, header, body))

    }


}

