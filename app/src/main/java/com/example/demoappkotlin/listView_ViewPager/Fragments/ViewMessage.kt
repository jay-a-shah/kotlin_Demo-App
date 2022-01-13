package com.example.demoappkotlin.listView_ViewPager.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.demoappkotlin.R

class ViewMessage : Fragment() {
    lateinit var display:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view_message, container, false)
        display = view.findViewById(R.id.textViewMyFouriteFragment)
        display.text = arguments?.getString("message")
        return view
    }
}