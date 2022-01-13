package com.example.demoappkotlin.listView_ViewPager.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.demoappkotlin.listView_ViewPager.Fragments.MyFavourites
import com.example.demoappkotlin.listView_ViewPager.Fragments.Recent

class ViewPagerAdapter(fragManager: FragmentManager): FragmentPagerAdapter(fragManager){
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                return Recent() }
            1 -> { return MyFavourites() }
            else -> { return Recent() }
        }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return  "Recent" }
            1 -> {
                return  "My Favourite"
            }

        }
        return super.getPageTitle(position)
    }

}
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentPagerAdapter
//
//class PageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
//    override fun getCount(): Int {
//        return 3;
//    }
//
//    override fun getItem(position: Int): Fragment {
//        when(position) {
//            0 -> {
//                return Fragment1()
//            }
//            1 -> {
//                return Fragment2()
//            }
//            2 -> {
//                return Fragment3()
//            }
//            else -> {
//                return Fragment1()
//            }
//        }
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        when(position) {
//            0 -> {
//                return "Tab 1"
//            }
//            1 -> {
//                return "Tab 2"
//            }
//            2 -> {
//                return "Tab 3"
//            }
//        }
//        return super.getPageTitle(position)
//    }
//
//}
//
