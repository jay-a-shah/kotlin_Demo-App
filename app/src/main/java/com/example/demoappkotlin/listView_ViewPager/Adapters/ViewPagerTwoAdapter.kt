package com.example.demoappkotlin.listView_ViewPager.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demoappkotlin.listView_ViewPager.Fragments.MyFavourites
import com.example.demoappkotlin.listView_ViewPager.Fragments.Recent

class ViewPagerTwoAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Recent()
            1 -> MyFavourites()
            6 -> MyFavourites()
            else -> Recent()
        }
    }
}