package com.example.demoappkotlin.WebServices

import com.example.demoappkotlin.utils.BaseURL
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import com.example.demoappkotlin.BuildConfig
import com.example.demoappkotlin.listviewpager.modelclasses.CreateUser
import com.example.demoappkotlin.listviewpager.modelclasses.ModelSingleUserApi
import com.example.demoappkotlin.utils.ENDPOINTCREATEUSER
import com.example.demoappkotlin.utils.ENDPOINTSINGLEUSER

interface ApiInterface {
    @GET(ENDPOINTSINGLEUSER)
    fun singleUserApi(@Path("id") userId: Int): Call<ModelSingleUserApi>

    @POST(ENDPOINTCREATEUSER)
    fun addUser(@Body userData: CreateUser): Call<CreateUser>

    companion object {
        private val okHttpClientBuilder = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(OkHttpProfilerInterceptor())
            }
        }

        fun getRetrofitObject(): ApiInterface{
            val retrofit = Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClientBuilder.build()).build().create(ApiInterface::class.java)
            return retrofit
        }
    }
}

