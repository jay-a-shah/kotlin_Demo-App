package com.example.demoappkotlin.activityAndFragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.demoappkotlin.R

class ActivityLifecycle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.d("Lifecycle2", "OnCreate")
        val firstFragment = FragmentOne()
        val secondFragment = FragmentTwo()
        val btnFirstFrag: Button = findViewById(R.id.btnFragmentOne)
        btnFirstFrag.setOnClickListener { supportFragmentManager.beginTransaction().apply { replace(R.id.fragmentOne, firstFragment)
            addToBackStack(null)
            commit()
            }
        }
        val btnSecondFrag = findViewById<Button>(R.id.btnFragmentTwo)
        btnSecondFrag.setOnClickListener { supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentOne, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle2", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle2", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle2", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle2", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle2", "OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle2", "OnRestart")
    }
}