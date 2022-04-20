package com.example.demoappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.demoappkotlin.utils.ZERO
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_design_library.drawerLayout
import kotlinx.android.synthetic.main.activity_design_library.navView
import kotlinx.android.synthetic.main.activity_design_library.toolbar

class DesignLibraryActivity : AppCompatActivity() {
    private lateinit var actionBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design_library)
        setSupportActionBar(toolbar)
        actionBarToggle = ActionBarDrawerToggle(this,drawerLayout, ZERO, ZERO)
        drawerLayout.addDrawerListener(actionBarToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                    Intent(this,CoordinatorLayoutActivty::class.java).apply {
                        startActivity(this)
                    }
                    true
                }
                R.id.people -> {
                    Toast.makeText(this, "People", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        this.drawerLayout.openDrawer(navView)
//        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)){
//           this.drawerLayout.closeDrawer(GravityCompat.START)
//       } else {
//           super.onBackPressed()
//       }
        return true
    }


    override fun onBackPressed() {
       if (this.drawerLayout.isDrawerOpen(GravityCompat.START)){
           this.drawerLayout.closeDrawer(GravityCompat.START)
       } else {
           super.onBackPressed()
       }
    }
}