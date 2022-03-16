package com.example.demoappkotlin.onewaytwowaydatabinding

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoappkotlin.binding_adapter.BindingModel

class MainViewModel : ViewModel() {

    val username = MutableLiveData("")
    val email = MutableLiveData("")
    val image = MutableLiveData(BindingModel("", ""))
    val msg = MutableLiveData<String>()
    // val age = MutableLiveData<Int>(1)

    fun loginResult(): LiveData<String> = msg
    fun validation() {
        if (username.value?.isEmpty() == true) {
            msg.value = "Enter Yor UserName"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.value.toString()).matches()) {
            msg.value = "Enter Your Email"
        } else {
            msg.value = "Login Successful"
        }
    }
}


//data class userImage(var imageUrl: String)