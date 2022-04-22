package com.example.demoappkotlin.mvvm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoappkotlin.mvvm.ViewModel.RecyclerMVVMAdapter
import com.example.demoappkotlin.mvvm.ViewModel.RecyclerViewModel
import com.example.demoappkotlin.R
import com.example.demoappkotlin.databinding.ActivityMvvmactivityBinding
import com.example.demoappkotlin.utils.TagMainActivity
import kotlinx.android.synthetic.main.activity_mvvmactivity.recyclerview

class MVVMActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvvmactivityBinding
    lateinit var recyclerViewModel: RecyclerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvmactivity)
        recyclerViewModel = ViewModelProvider(this).get(RecyclerViewModel::class.java)
        recyclerViewModel.getAllMovies()
        val TAG = TagMainActivity
        val adapter = RecyclerMVVMAdapter()
        recyclerview.adapter = adapter
        recyclerViewModel.movieList.observe(this, Observer {
            if (it == null) {
                Log.d(TAG, getString(R.string.Log_msg) + it)
                Toast.makeText(this, getString(R.string.toast_data_is_not_there), Toast.LENGTH_LONG)
            } else {
                adapter.setMovieList(it)
            }
        })
    }
}
