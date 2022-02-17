package com.example.demoappkotlin.differentLayout
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.demoappkotlin.R

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        val linearLayoutBtn = findViewById<Button>(R.id.btnLinearLayout)
        linearLayoutBtn.setOnClickListener {
            val intent = Intent(applicationContext, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}