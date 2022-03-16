package com.example.demoappkotlin.binding_adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageUrl: String) {
    Picasso.get().load(imageUrl).into(this)
}