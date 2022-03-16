package com.example.demoappkotlin.mvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoappkotlin.mvvm.model.Movie
import com.example.demoappkotlin.mvvm.model.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewModel : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()
    val newString = MutableLiveData<String>()
    val retrofitService = RetrofitService.getInstance()

    fun getAllMovies() {
        retrofitService.getAllMovies().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.value = response.body()
            }
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}