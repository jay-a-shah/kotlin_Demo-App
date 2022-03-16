package com.example.demoappkotlin.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoappkotlin.mvvm.model.RetrofitService
import com.example.demoappkotlin.mvvm.viewmodel.RecyclerMVVMAdapter
import com.example.demoappkotlin.mvvm.viewmodel.RecyclerViewModel
import com.example.demoappkotlin.R
import com.example.demoappkotlin.databinding.ActivityMvvmactivityBinding
import kotlinx.android.synthetic.main.activity_mvvmactivity.*

class MVVMActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvvmactivityBinding
    lateinit var recyclerViewModel: RecyclerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvmactivity)
        recyclerViewModel = ViewModelProvider(this).get(RecyclerViewModel::class.java)
        recyclerViewModel.getAllMovies()
        val TAG = "MainActivity"
        val retrofitService = RetrofitService.getInstance()
        val adapter = RecyclerMVVMAdapter()
        recyclerview.adapter = adapter
       // recyclerViewModel.newString = "Jay"
        recyclerViewModel.movieList.observe(this, Observer {
            if (it == null) {
                Log.d(TAG, "onCreate: $it")
                Toast.makeText(this, "Data is Not There", Toast.LENGTH_LONG)
            } else {

                adapter.setMovieList(it)
            }

        })
    }
}
