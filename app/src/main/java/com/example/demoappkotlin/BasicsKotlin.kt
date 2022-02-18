package com.example.demoappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.example.demoappkotlin.utils.ZERO

class BasicsKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basics_kotlin)
        val actionbar = supportActionBar
        actionbar?.title = getString(R.string.title_registration_form)
        val submitBtn = findViewById<Button>(R.id.btnSubmit)
        submitBtn.setOnClickListener {
            showToast()
        }
    }

    fun showToast() {
        val toastView = layoutInflater.inflate(
            R.layout.custom_toast, findViewById(R.id.customToastLayout))
        val myToast = Toast(applicationContext)
        myToast.apply {
            duration = Toast.LENGTH_SHORT
            setGravity(Gravity.CENTER_VERTICAL, ZERO, ZERO)
            view = toastView//setting the view of custom toast layout
            show()
        }
    }
}

