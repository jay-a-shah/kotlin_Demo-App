package com.example.demoappkotlin.listviewpager.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.demoappkotlin.R

class ViewMessageWithSafeArgs : Fragment() {
    lateinit var message: TextView
    private val argument : ViewMessageWithSafeArgsArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_message_with_safe_args, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message = view.findViewById(R.id.textViewMyFouriteFragment)
        message.text = argument.dataIn
    }
}