package com.example.demoappkotlin.differentLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import com.example.demoappkotlin.R

class ConstraintLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
        var spinner: Spinner = findViewById(R.id.spinner_constraint_layout)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                Toast.makeText(
                    applicationContext,
                    "You have selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}