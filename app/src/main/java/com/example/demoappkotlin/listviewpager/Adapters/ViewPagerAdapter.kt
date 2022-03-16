package com.example.demoappkotlin.listviewpager.Adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.Fragments.MyFavourites
import com.example.demoappkotlin.listviewpager.Fragments.Recent
import com.example.demoappkotlin.utils.ONE
import com.example.demoappkotlin.utils.TWO
import com.example.demoappkotlin.utils.ZERO

class ViewPagerAdapter(val context: Context, fragManager: FragmentManager): FragmentPagerAdapter(fragManager){

    override fun getCount(): Int {
        return TWO
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            ZERO -> { return Recent() }
            ONE -> { return MyFavourites() }
            else -> { return Recent() }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            ZERO -> { return context.getString(R.string.tab_title_recent)}
            ONE -> { return  context.getString(R.string.tab_title_myFavourite) }
        }
        return super.getPageTitle(position)
    }
}