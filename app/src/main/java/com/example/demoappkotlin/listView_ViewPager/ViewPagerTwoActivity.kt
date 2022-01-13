package com.example.demoappkotlin.listView_ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.Adapters.ViewPagerTwoAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_two)

        val viewPagerTwo = findViewById<ViewPager2>(R.id.viewPagerTwo)
        val tabLayout  = findViewById<TabLayout>(R.id.tabLayoutViewPagerTwo)
        viewPagerTwo.adapter = ViewPagerTwoAdapter(this)
        TabLayoutMediator(tabLayout,viewPagerTwo) { tab, position ->
            val tabNames = listOf("Hello", "My Favourites","Jay","Dhruv")
            tab.text = tabNames[position]
        }.attach()
    }
}