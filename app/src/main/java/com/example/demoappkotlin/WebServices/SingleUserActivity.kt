package com.example.demoappkotlin.WebServices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.modelclasses.ModelSingleUserApi
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_single_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingleUserActivity : AppCompatActivity() {
    lateinit var retrofit: ApiInterface
    lateinit var interceptor: OkHttpProfilerInterceptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_user)
        retrofit = ApiInterface.getRetrofitObject()
        retrofit.singleUserApi(intent.getIntExtra("Selected User",0)).enqueue(object : Callback<ModelSingleUserApi>{
            override fun onResponse(
                call: Call<ModelSingleUserApi>,
                response: Response<ModelSingleUserApi>
            ) {
               response.body()?.let {
                   idForSingleUser.text = it.data?.id.toString()
                   firstNameForSingleUser.text = it.data?.first_name
                   lastNameForSingleUser.text = it.data?.last_name
                   emailForSingleUser.text = it.data?.email
                   Picasso.get().load(it.data?.avatar).into(imageViewForSingleUser)
               }
            }

            override fun onFailure(call: Call<ModelSingleUserApi>, t: Throwable) {
                Log.e("ERROR: ","ERROR CAUGHT")
                Toast.makeText(this@SingleUserActivity, "No User", Toast.LENGTH_SHORT).show()
            }
        })
    }

}