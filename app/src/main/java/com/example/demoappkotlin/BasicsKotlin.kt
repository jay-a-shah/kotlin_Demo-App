package com.example.demoappkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class BasicsKotlin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basics_kotlin)
        val actionbar = supportActionBar
        actionbar?.title = "Registration Form"
        val submitBtn = findViewById<Button>(R.id.btn_submit)
        submitBtn.setOnClickListener {
            showToast()
        }
    }
    fun showToast() {
        val toastView = layoutInflater.inflate(
            R.layout.custom_toast, findViewById(R.id.customToastLayout))
        val myToast = Toast(applicationContext)
        myToast.duration = Toast.LENGTH_SHORT
        myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        myToast.view = toastView//setting the view of custom toast layout
        myToast.show()
    }
}

