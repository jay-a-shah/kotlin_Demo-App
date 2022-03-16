package com.example.demoappkotlin.mvvm.model

import com.example.demoappkotlin.BuildConfig
import com.example.demoappkotlin.utils.BASEURLMOVIELIST
import com.example.demoappkotlin.utils.MOVIELISTJSON
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET(MOVIELISTJSON)
    fun getAllMovies(): Call<List<Movie>>

    companion object {
        private val okHttpClientBuilder = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(OkHttpProfilerInterceptor())
            }
        }

        fun getInstance(): RetrofitService {
            val retrofit = Retrofit.Builder().baseUrl(BASEURLMOVIELIST).addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build()).build().create(RetrofitService::class.java)
            return retrofit
        }
    }
}
