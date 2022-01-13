package com.example.demoappkotlin.listView_ViewPager.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.demoappkotlin.Interface.Communicator
import com.example.demoappkotlin.R

class AddMessage : Fragment() {
    private lateinit var communicator: Communicator
    private lateinit var btnSend: Button
    private lateinit var editText: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_message, container, false)
        communicator = activity as Communicator
        editText = view.findViewById(R.id.editTextRecentFragment)
        btnSend = view.findViewById(R.id.btnRecentFragment)
        btnSend.setOnClickListener {
            communicator.passDataComm(editText.text.toString())
        }
        return view
    }
}