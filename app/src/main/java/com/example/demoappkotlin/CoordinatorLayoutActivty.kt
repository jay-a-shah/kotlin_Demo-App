package com.example.demoappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_coordinator_layout_activty.btn_Fab_Coordinator
import kotlinx.android.synthetic.main.activity_coordinator_layout_activty.toolbar
import kotlinx.android.synthetic.main.activity_coordinator_layout_activty.toolbar_layout

class CoordinatorLayoutActivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout_activty)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar_layout.title = title
        toolbar.setNavigationOnClickListener {
            finish()
        }
        btn_Fab_Coordinator.setOnClickListener {
        }
    }
}