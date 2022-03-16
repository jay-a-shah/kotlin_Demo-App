package com.example.demoappkotlin.mvc.Model

import android.text.TextUtils

import android.util.Patterns
import com.example.demoappkotlin.utils.TWO


class LoginModel(val email: String?, val password: String?) : ILoginModel{
    override fun getUserEmail(): String? {
        return email
    }

    override fun getUserPassword(): String? {
       return password
    }

    override fun isValid(): Int {
        return if (TextUtils.isEmpty(getUserEmail()))
            0
        else if (!Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches())
            1
        else if (TextUtils.isEmpty(getUserPassword()))
            TWO
        else
            -1
    }
}