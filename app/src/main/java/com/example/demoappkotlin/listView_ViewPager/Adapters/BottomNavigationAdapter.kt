package com.example.demoappkotlin.listView_ViewPager.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.demoappkotlin.listView_ViewPager.Fragments.FirstFragment
import com.example.demoappkotlin.listView_ViewPager.Fragments.MyFavourites
import com.example.demoappkotlin.listView_ViewPager.Fragments.Recent
import com.example.demoappkotlin.utils.*

class BottomNavigationAdapter(var fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return THREE
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            ZERO -> Recent()
            ONE -> MyFavourites()
            TWO -> FirstFragment()
            else -> FirstFragment()
        }
    }
}