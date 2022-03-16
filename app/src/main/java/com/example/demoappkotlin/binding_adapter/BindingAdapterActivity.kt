package com.example.demoappkotlin.binding_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.demoappkotlin.R
import com.example.demoappkotlin.databinding.ActivityBindingAdapterBinding

class BindingAdapterActivity : AppCompatActivity() {
    lateinit var bindingAdapter: ActivityBindingAdapterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binding_adapter)
        bindingAdapter = DataBindingUtil.setContentView(this,R.layout.activity_binding_adapter)
        val post = BindingModel("Jay","https://cdn.britannica.com/86/170586-050-AB7FEFAE/Taj-Mahal-Agra-India.jpg")
        bindingAdapter.binding = post
    }
}