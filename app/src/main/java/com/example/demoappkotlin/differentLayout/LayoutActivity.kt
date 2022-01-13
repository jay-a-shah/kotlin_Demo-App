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

        val linearLayoutBtn = findViewById<Button>(R.id.linearLayoutBtn)
        linearLayoutBtn.setOnClickListener {
            val intent = Intent(applicationContext, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
        var relativeLayoutBtn = findViewById<Button>(R.id.relativeLayoutBtn)
        relativeLayoutBtn.setOnClickListener {
            val intent = Intent(applicationContext, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
        val constraintLayoutBtn = findViewById<Button>(R.id.constraintLayoutBtn)
        constraintLayoutBtn.setOnClickListener {
            val intent = Intent(applicationContext, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }
        val gridLayoutBtn = findViewById<Button>(R.id.gridLayoutBtn)
        gridLayoutBtn.setOnClickListener {
            val intent = Intent(applicationContext, GridLayoutActivity::class.java)
            startActivity(intent)
        }
        val frameLayoutBtn = findViewById<Button>(R.id.frameLayoutBtn)
        frameLayoutBtn.setOnClickListener {
            val intent = Intent(applicationContext, FrameLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}