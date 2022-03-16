package com.example.demoappkotlin.WebServices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.modelclasses.CreateUser
import kotlinx.android.synthetic.main.activity_create_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateUserActivity : AppCompatActivity() {
    lateinit var retrofit: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
       retrofit = ApiInterface.getRetrofitObject()
        btnSubmitForCreateUser.setOnClickListener {
            val newUser = CreateUser(editTextForJob.text.toString(),editTextForName.text.toString())
            retrofit.addUser(newUser).enqueue(object : Callback<CreateUser?> {

                override fun onResponse(call: Call<CreateUser?>, response: Response<CreateUser?>) {
                    Toast.makeText(this@CreateUserActivity, "User Added ", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<CreateUser?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
            finish()
        }
        }

}