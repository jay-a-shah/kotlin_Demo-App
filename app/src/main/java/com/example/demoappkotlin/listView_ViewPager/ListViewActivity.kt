package com.example.demoappkotlin.listView_ViewPager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.demoappkotlin.R

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val btnListView = findViewById<Button>(R.id.btnListViewOne)
        btnListView.setOnClickListener {
            val intent = Intent(applicationContext, SimpleListViewActivity::class.java)
            startActivity(intent)
        }
        val btnListViewArray = findViewById<Button>(R.id.btnListViewTwo)
        btnListViewArray.setOnClickListener {
            val intent = Intent(applicationContext, SimpleListViewWithArrayActivity::class.java)
            startActivity(intent)
        }
        val btnCustomListView = findViewById<Button>(R.id.btnListViewThree)
        btnCustomListView.setOnClickListener {
            val intent = Intent(applicationContext, CustomListViewActivity::class.java)
            startActivity(intent)
        }
        val btnRecyclerView = findViewById<Button>(R.id.btnRecyclerView)
        btnRecyclerView.setOnClickListener {
            val intent = Intent(applicationContext, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        val btnRecyclerViewGridLayout = findViewById<Button>(R.id.btnRecyclerViewGridLayout)
        btnRecyclerViewGridLayout.setOnClickListener {
            val intent = Intent(applicationContext, RecyclerViewWithGridLayoutActivity::class.java)
            startActivity(intent)
        }
        val btnViewPager = findViewById<Button>(R.id.btnViewPager)
        btnViewPager.setOnClickListener {
            val intent = Intent(applicationContext, ViewPagerActivity::class.java)
            startActivity(intent)
        }
        val btnViewPagerTwo = findViewById<Button>(R.id.btnViewPagerTwoLayout)
        btnViewPagerTwo.setOnClickListener {
            val intent = Intent(applicationContext, ViewPagerTwoActivity::class.java)
            startActivity(intent)
        }
        val btnBottomNav = findViewById<Button>(R.id.btnBottomNavigationLayout)
        btnBottomNav.setOnClickListener {
            val intent = Intent(applicationContext, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
        val btnViewPagerRecycler = findViewById<Button>(R.id.btnViewPagerTwoRecyclerAdapter)
        btnViewPagerRecycler.setOnClickListener {
            val intent = Intent(applicationContext, ViewPagerThreeActivity::class.java)
            startActivity(intent)
        }
        val btnExpandableListView = findViewById<Button>(R.id.btnExpandableListView)
        btnExpandableListView.setOnClickListener {
            val intent = Intent(applicationContext, ExpandableListViewActivity::class.java)
            startActivity(intent)
        }
        val btnExpandableRecyclerView = findViewById<Button>(R.id.btnExpandableRecyclerView)
        btnExpandableRecyclerView.setOnClickListener {
            val intent = Intent(applicationContext, ExpandableRecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}