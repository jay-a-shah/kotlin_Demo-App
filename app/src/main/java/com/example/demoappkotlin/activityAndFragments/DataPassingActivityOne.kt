package com.example.demoappkotlin.activityAndFragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.demoappkotlin.R

class DataPassingActivityOne : AppCompatActivity() {
    lateinit var editTextData: EditText
    lateinit var btnApply: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_passing_one)
        editTextData = findViewById(R.id.editTextDataPassingOne)
        btnApply = findViewById(R.id.btnDataPassingOne)
        btnApply.setOnClickListener {
            val txt = editTextData.text.toString()
            val intent = Intent(this, DataPassingTwoActivity::class.java).also { it.putExtra(getString(R.string.label_putextra), txt)
            }
            startActivity(intent)
        }
    }
}