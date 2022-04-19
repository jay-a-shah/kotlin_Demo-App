package com.example.demoappkotlin.listviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.Adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class ViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this,supportFragmentManager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }
}