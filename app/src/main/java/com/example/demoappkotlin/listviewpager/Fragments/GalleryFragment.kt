package com.example.demoappkotlin.listviewpager.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.demoappkotlin.R

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnNextFrag).setOnClickListener {
            val action = GalleryFragmentDirections.actionGalleryFragmentToAddMessageFragment()
            findNavController().navigate(action)
        }
    }
}