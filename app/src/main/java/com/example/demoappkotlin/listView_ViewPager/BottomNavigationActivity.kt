package com.example.demoappkotlin.listView_ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.Adapters.BottomNavigationAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var  bottomNavigationView : BottomNavigationView
    lateinit var bottomNav : ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
       bottomNav = findViewById(R.id.viewPagerBottomNavigation)
        setViewPagerAdapter()
        setBottomNavigation()

    }

    private fun setBottomNavigation() {

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.icon_home ->  bottomNav.currentItem = 0
                R.id.icon_search -> bottomNav.currentItem = 1
                R.id.icon_profile -> bottomNav.currentItem = 2
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun setViewPagerAdapter(){
        bottomNav.adapter = BottomNavigationAdapter(supportFragmentManager)


    }
}