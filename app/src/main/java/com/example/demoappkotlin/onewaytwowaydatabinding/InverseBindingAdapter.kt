package com.example.demoappkotlin.onewaytwowaydatabinding

import android.widget.EditText
import androidx.databinding.InverseBindingAdapter


//@BindingAdapter("android:text")
//fun setText(view: EditText, value: Float?) {
//    view.text = value?.let { SpannableStringBuilder(value.toString()) } ?: SpannableStringBuilder("")
//}
//
//@InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
//fun captureTextValue(view: TextView, originalValue: CharSequence?): String? {
//    val newValue = view.text
//    val oldValue: CharSequence = view.get()
//    if (oldValue == null) {
//        value.set(newValue)
//    } else if (!contentEquals(newValue, oldValue)) {
//        value.set(newValue)
//    }
//}
//@BindingAdapter(value = ["android:textAttrChanged","android:customText"])



@InverseBindingAdapter(attribute = "android:customText", event = "android:textAttrChanged")
fun getTextChanged(editText: EditText): String{
    return editText.text.toString().uppercase()
}

