package com.example.demoappkotlin.mvc.Controller

import com.example.demoappkotlin.mvc.Model.LoginModel
import com.example.demoappkotlin.mvc.View.ILoginView

class LoginController(private var loginView : ILoginView): ILoginController {
    override fun onLogin(email: String,Password: String) {
        val user = LoginModel(email,Password)
        val loginCode = user.isValid()
        if (loginCode == 0)
        {
            loginView.onFailure("Please Enter Email")
        }else if (loginCode == 1){
            loginView.onFailure(" Please Enter a Valid Email")
        }else if (loginCode == 2){
            loginView.onFailure("Please Enter a Password")
        }else{
            loginView.onSucees("Login Successfull")
        }
    }
}