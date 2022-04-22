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
        bindingAdapter = DataBindingUtil.setContentView(this, R.layout.activity_binding_adapter)
        val post = BindingModel(getString(R.string.name_jay), getString(R.string.image_url))
        bindingAdapter.binding = post
    }
}