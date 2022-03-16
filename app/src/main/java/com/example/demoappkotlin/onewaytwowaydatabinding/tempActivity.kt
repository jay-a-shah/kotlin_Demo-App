package com.example.demoappkotlin.onewaytwowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.demoappkotlin.R
import com.example.demoappkotlin.databinding.ActivityTempBinding
import kotlinx.android.synthetic.main.activity_temp.*

class tempActivity : AppCompatActivity() {
   lateinit var binding: ActivityTempBinding

   lateinit var  adapter: tempAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_temp)
         var apiResponse = ArrayList<ImageResponseModel>()
            for (i in 1..30){
                apiResponse.add(ImageResponseModel("https://cdn.britannica.com/86/170586-050-AB7FEFAE/Taj-Mahal-Agra-India.jpg",2,2))
                apiResponse. add(ImageResponseModel("https://blog.hubspot.com/hubfs/what-is-a-blog-2.jpg",3,8))
            }
        adapter = tempAdapter(apiResponse)
        rcv2.adapter = adapter
        }


}

