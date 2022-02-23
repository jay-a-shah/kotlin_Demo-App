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
        val btnBottomNav = findViewById<Button>(R.id.btnBottomNavigationLayout)
        btnBottomNav.setOnClickListener {
            val intent = Intent(applicationContext, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }
}