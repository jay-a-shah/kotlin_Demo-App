package com.example.demoappkotlin.listView_ViewPager.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.demoappkotlin.listView_ViewPager.Fragments.FirstFragment
import com.example.demoappkotlin.listView_ViewPager.Fragments.MyFavourites
import com.example.demoappkotlin.listView_ViewPager.Fragments.Recent

class BottomNavigationAdapter(var fm:FragmentManager):FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
       return when (position){
           0 -> Recent()
           1 -> MyFavourites()
           2 -> FirstFragment()
           else -> FirstFragment()

       }
    }
}