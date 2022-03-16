package com.example.demoappkotlin.WebServices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.demoappkotlin.R
import com.example.demoappkotlin.databinding.ActivityDataBindingBinding
import com.example.demoappkotlin.listviewpager.modelclasses.SampleDataClassForBinding

class DataBindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        binding.data = SampleDataClassForBinding("hello","Jay")
    }
}