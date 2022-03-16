package com.example.demoappkotlin.mvc.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.demoappkotlin.mvc.Controller.ILoginController
import com.example.demoappkotlin.mvc.Controller.LoginController
import com.example.demoappkotlin.R
import com.example.demoappkotlin.databinding.ActivityMvcactivityBinding

class MVCActivity : AppCompatActivity(),ILoginView{
     lateinit var loginController: ILoginController
     lateinit var binding: ActivityMvcactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvcactivity)
        loginController = LoginController(this)
        binding.btnSubmitMVC.setOnClickListener {
            loginController.onLogin(binding.nameMVC.text.toString(),binding.emailMVC.text.toString())
        }
    }

    override fun onSucees(message: String) {
       Toast.makeText(this,"Logijn Successful",Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(message: String) {
        Toast.makeText(this,"Login Failure",Toast.LENGTH_LONG).show()
    }
}