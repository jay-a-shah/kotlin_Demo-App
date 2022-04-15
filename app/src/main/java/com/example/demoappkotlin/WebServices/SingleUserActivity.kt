package com.example.demoappkotlin.WebServices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelSingleUserApi
import com.example.demoappkotlin.utils.BaseURL
import com.example.demoappkotlin.utils.ZERO
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_single_user.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SingleUserActivity : AppCompatActivity(), SingleUserInterface {
    lateinit var retrofit: ApiInterface
    lateinit var interceptor: OkHttpProfilerInterceptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_user)
        retrofit = ApiInterface.getRetrofitObject()
        retrofit.singleUserApi(intent.getIntExtra("Selected User", ZERO)).enqueue(object : Callback<ModelSingleUserApi> {

                override fun onResponse(call: Call<ModelSingleUserApi>, response: Response<ModelSingleUserApi>) {
                    response.body()?.data?.apply{
                        idForSingleUser.text = this.id.toString()
                        firstNameForSingleUser.text = this.first_name
                        lastNameForSingleUser.text = this.last_name
                        emailForSingleUser.text = this.email
                        Picasso.get().load(this.avatar).into(imageViewForSingleUser)
                    }
                }

                override fun onFailure(call: Call<ModelSingleUserApi>, t: Throwable) {
                    Log.e("ERROR: ", "ERROR CAUGHT")
                    Toast.makeText(this@SingleUserActivity, getString(R.string.toast_no_user), Toast.LENGTH_SHORT).show()
                }
            })
    }

    override fun onUserClicked(position: Int) {
       Intent(this, SingleUserActivity::class.java).apply {
           putExtra("Selected User", position)
           startActivity(this)
       }
    }
}