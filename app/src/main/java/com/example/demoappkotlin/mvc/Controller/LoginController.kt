package com.example.demoappkotlin.mvc.Controller

import android.content.Context
import com.example.demoappkotlin.R
import com.example.demoappkotlin.mvc.Model.LoginModel
import com.example.demoappkotlin.mvc.View.ILoginView
import com.example.demoappkotlin.utils.ONE
import com.example.demoappkotlin.utils.TWO
import com.example.demoappkotlin.utils.ZERO

class LoginController(private var loginView: ILoginView, private val applicationContext: Context) : ILoginController {

    override fun onLogin(email: String, Password: String) {
        val user = LoginModel(email, Password)
        val loginCode = user.isValid()
        if (loginCode == ZERO) {
            loginView.onFailure(applicationContext.getString(R.string.toast_enter_email))
        } else if (loginCode == ONE) {
            loginView.onFailure(applicationContext.getString(R.string.toast_enter_valid_email))
        } else if (loginCode == TWO) {
            loginView.onFailure(applicationContext.getString(R.string.toast_enter_password))
        } else {
            loginView.onSucees(applicationContext.getString(R.string.toast_login_successful))
        }
    }
}