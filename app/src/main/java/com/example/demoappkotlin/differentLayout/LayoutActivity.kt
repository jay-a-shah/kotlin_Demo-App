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
        var btnRelativeLayout = findViewById<Button>(R.id.btnRelativeLayout)
        btnRelativeLayout.setOnClickListener {
            val intent = Intent(applicationContext, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
        val btnConstraintLayout = findViewById<Button>(R.id.btnConstraintLayout)
        btnConstraintLayout.setOnClickListener {
            val intent = Intent(applicationContext, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }
        val btnGridLayout = findViewById<Button>(R.id.btnGridLayout)
        btnGridLayout.setOnClickListener {
            val intent = Intent(applicationContext, GridLayoutActivity::class.java)
            startActivity(intent)
        }
        val btnFrameLayout = findViewById<Button>(R.id.btnFrameLayout)
        btnFrameLayout.setOnClickListener {
            val intent = Intent(applicationContext, FrameLayoutActivity::class.java)
            startActivity(intent)
        }
        val btnLinearLayout = findViewById<Button>(R.id.btnLinearLayout)
        btnLinearLayout.setOnClickListener {
            val intent = Intent(applicationContext, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}