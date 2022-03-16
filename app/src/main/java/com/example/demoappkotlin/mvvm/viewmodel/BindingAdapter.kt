package com.example.demoappkotlin.mvvm.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrlAdapter")
fun ImageView.setImageUrl(imageUrl: String){
  Picasso.get().load(imageUrl).into(this)
}