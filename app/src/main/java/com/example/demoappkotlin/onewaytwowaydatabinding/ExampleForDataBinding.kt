package com.example.demoappkotlin.onewaytwowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingListener
import com.example.demoappkotlin.R
import com.example.demoappkotlin.binding_adapter.BindingModel
import com.example.demoappkotlin.databinding.ActivityExampleForDataBindingBinding

class ExampleForDataBinding : AppCompatActivity() {
    lateinit var binding: ActivityExampleForDataBindingBinding
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_example_for_data_binding)
        binding.mainviewModel = viewModel
        binding.lifecycleOwner = this
        val img = BindingModel("","https://cdn.britannica.com/86/170586-050-AB7FEFAE/Taj-Mahal-Agra-India.jpg")
       // viewModel.Image.value = img
            viewModel.loginResult().observe(this) { result ->
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }


        fun setTextChangedListener(editText: EditText, listener: InverseBindingListener) {
            editText.addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    listener.onChange()
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })
        }


    }
}