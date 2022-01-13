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

        val listViewBtn1 = findViewById<Button>(R.id.list_view_btn_1)
        listViewBtn1.setOnClickListener {
            val intent = Intent(applicationContext, SimpleListViewActivity::class.java)
            startActivity(intent)
        }
        val listViewBtn2 = findViewById<Button>(R.id.list_view_btn_2)
        listViewBtn2.setOnClickListener {
            val intent = Intent(applicationContext, SimpleListViewWithArrayActivity::class.java)
            startActivity(intent)
        }
        val listViewBtnCustomLayout = findViewById<Button>(R.id.list_view_btn_3)
        listViewBtnCustomLayout.setOnClickListener {
            val intent = Intent(applicationContext, CustomListViewActivity::class.java)
            startActivity(intent)
        }
        val recyclerViewBtn = findViewById<Button>(R.id.recyclerViewBtn)
        recyclerViewBtn.setOnClickListener {
            val intent = Intent(applicationContext, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        val recyclerViewGridLayoutBtn = findViewById<Button>(R.id.recyclerViewGridLayoutBtn)
        recyclerViewGridLayoutBtn.setOnClickListener {
            val intent = Intent(applicationContext, RecyclerViewWithGridLayoutActivity::class.java)
            startActivity(intent)
        }
        val viewPagerBtn = findViewById<Button>(R.id.viewPagerLayoutBtn)
        viewPagerBtn.setOnClickListener {
            val intent = Intent(applicationContext, ViewPagerActivity::class.java)
            startActivity(intent)
        }
        val viewPagerTwoBtn = findViewById<Button>(R.id.viewPagerTwoLayoutBtn)
        viewPagerTwoBtn.setOnClickListener {
            val intent = Intent(applicationContext, ViewPagerTwoActivity::class.java)
            startActivity(intent)
        }
        val bottomNavBtn = findViewById<Button>(R.id.bottomNavigationLayoutBtn)
        bottomNavBtn.setOnClickListener {
            val intent = Intent(applicationContext, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
        val viewPagerRecyclerBtn = findViewById<Button>(R.id.viewPagerTwoRecyclerAdapterBtn)
        viewPagerRecyclerBtn.setOnClickListener {
            val intent = Intent(applicationContext, ViewPagerThreeActivity::class.java)
            startActivity(intent)
        }
        val expandableListViewBtn = findViewById<Button>(R.id.expandableListViewBtn)
        expandableListViewBtn.setOnClickListener {
            val intent = Intent(applicationContext, ExpandableListViewActivity::class.java)
            startActivity(intent)
        }
        val expandableRecyclerViewBtn = findViewById<Button>(R.id.expandableRecyclerViewBtn)
        expandableRecyclerViewBtn.setOnClickListener {
            val intent = Intent(applicationContext, ExpandableRecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}