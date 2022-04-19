package com.example.demoappkotlin.listviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.Adapters.ViewPagerThreeAdapter

class ViewPagerThreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_three)
        val imagesList = listOf(R.drawable.android, R.drawable.kotlin, R.drawable.larvel )
        val adapter = ViewPagerThreeAdapter(imagesList)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter
    }
}