package com.example.demoappkotlin.activityAndFragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.demoappkotlin.R

class DataPassingTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_passing_two)
        val intentValue = intent.getStringExtra(getString(R.string.label_putextra))
        findViewById<TextView>(R.id.tvDataPassingTwo).apply {
            text = intentValue.toString()
        }
    }
}