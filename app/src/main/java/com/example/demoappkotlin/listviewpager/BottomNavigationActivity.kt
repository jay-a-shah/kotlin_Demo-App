package com.example.demoappkotlin.listviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.Adapters.BottomNavigationAdapter
import com.example.demoappkotlin.utils.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var bottomNav: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNav = findViewById(R.id.viewPagerBottomNavigation)
        setViewPagerAdapter()
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.icon_home -> bottomNav.currentItem = ZERO
                R.id.icon_search -> bottomNav.currentItem = ONE
                R.id.icon_profile -> bottomNav.currentItem = TWO
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun setViewPagerAdapter() {
        bottomNav.adapter = BottomNavigationAdapter(supportFragmentManager)
    }
}