package com.example.demoappkotlin.listView_ViewPager.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.demoappkotlin.listView_ViewPager.Fragments.MyFavourites
import com.example.demoappkotlin.listView_ViewPager.Fragments.Recent
import com.example.demoappkotlin.utils.ONE
import com.example.demoappkotlin.utils.THREE
import com.example.demoappkotlin.utils.ZERO

class ViewPagerTwoAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return THREE
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            ZERO -> Recent()
            ONE -> MyFavourites()
            else -> Recent()
        }
    }
}