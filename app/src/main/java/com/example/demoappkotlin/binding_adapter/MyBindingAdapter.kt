package com.example.demoappkotlin.binding_adapter

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
//import androidx.databinding.InverseBindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setImageUrl")
fun ImageView.setImageUrl( imageUrl: String?){
    Picasso.get().load(imageUrl).into(this)
}
@BindingAdapter(value = ["basePrice","count"], requireAll = false)
fun TextView.setData( basePrice:Int,count:Int){
    text = (basePrice * count).toString()
}


@BindingAdapter(value = ["customText","android:customAttrChanged"], requireAll = false)
fun EditText.updateText(text: String?,listener: InverseBindingListener) {
    if (this.text.toString() != text){
        this.setText(text)
    }
    this.setSelection(text?.length ?: 0)
    this.doOnTextChanged{_ : CharSequence?,_ :Int, _ :Int,_:Int ->
        listener.onChange()
    }
}
@InverseBindingAdapter(attribute = "customText", event = "android:customAttrChanged")
fun EditText.getUpdatedText(): String? {
    return this.text.toString().uppercase()
}