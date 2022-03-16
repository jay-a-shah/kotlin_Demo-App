package com.example.demoappkotlin.MVC.View

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.demoappkotlin.R

class LoginScreenView :AppCompatActivity(), ILoginView{
    override fun showDialog(dialog: Dialog) {
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_progressbar)
        dialog.show()
    }
}