package com.example.demoappkotlin.mvc.Model

import android.text.TextUtils
import android.util.Patterns
import com.example.demoappkotlin.utils.NEGATIVEONE
import com.example.demoappkotlin.utils.ONE
import com.example.demoappkotlin.utils.TWO
import com.example.demoappkotlin.utils.ZERO

class LoginModel(val email: String?, val password: String?) : ILoginModel{

    override fun getUserEmail(): String? {
        return email
    }

    override fun getUserPassword(): String? {
       return password
    }

    override fun isValid(): Int {
        return if (TextUtils.isEmpty(getUserEmail()))
            ZERO
        else if (!Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches())
            ONE
        else if (TextUtils.isEmpty(getUserPassword()))
            TWO
        else
            NEGATIVEONE
    }
}