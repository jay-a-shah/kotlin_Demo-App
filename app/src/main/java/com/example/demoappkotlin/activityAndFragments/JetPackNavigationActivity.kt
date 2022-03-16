package com.example.demoappkotlin.activityAndFragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.demoappkotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class JetPackNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jet_pack_navigation)
        val navController = findNavController(R.id.navHost)
        val navBottom = findViewById<BottomNavigationView>(R.id.bottomNavigationJetPack)
        navBottom.setupWithNavController(navController)
    }
}