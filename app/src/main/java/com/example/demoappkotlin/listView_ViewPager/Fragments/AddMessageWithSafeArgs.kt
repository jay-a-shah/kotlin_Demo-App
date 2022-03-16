package com.example.demoappkotlin.listView_ViewPager.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.demoappkotlin.R

class AddMessageWithSafeArgs : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnRecentFragment).setOnClickListener {
            val action = AddMessageWithSafeArgsDirections.actionAddMessageFragmentToViewMessageFragment(
                    view.findViewById<Button>(R.id.editTextRecentFragment).text.toString())
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_message_with_safe_args, container, false)
    }
}