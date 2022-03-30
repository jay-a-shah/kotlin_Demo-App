package com.example.demoappkotlin.WebServices

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import com.example.demoappkotlin.MainActivity
import com.example.demoappkotlin.R
import com.example.demoappkotlin.utils.BaseURL
import com.example.demoappkotlin.utils.ENDPOINTFORLOGIN
import com.example.demoappkotlin.utils.REQUESTMETHODPOST
import com.example.demoappkotlin.utils.RESPONSECODE
import kotlinx.android.synthetic.main.activity_login_screen_with_api.*
import kotlinx.android.synthetic.main.activity_recycler_view_with_api.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class LoginScreenWithApi : AppCompatActivity() {
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen_with_api)
        dialog = Dialog(this)
        btnLoginPage.setOnClickListener {
            Thread {
                try {
                    sendPostRequest(editTextEmailForLogin.text.toString(), editTextPasswordForLogin.text.toString())
                }
                catch (ex: Exception) {
                    ex.printStackTrace()
                } }.start()
            showDialog()
        }
    }

    private fun sendPostRequest(username: String, password: String) {
        val credential = JSONObject()
        credential.put(getString(R.string.key_username), username)
        credential.put(getString(R.string.key_password), password)
        val url = URL("$BaseURL$ENDPOINTFORLOGIN")
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = REQUESTMETHODPOST
            setRequestProperty("Content-Type", "application/json")
            val wr = OutputStreamWriter(outputStream)
            wr.write(credential.toString())
            wr.flush()
            println("URL : $url")
            println("cred: $credential")
            println("Response Code: $responseCode")
            if (responseCode == RESPONSECODE) {
                val intent = Intent(applicationContext, RecyclerViewWithApi::class.java)
                startActivity(intent)
                finish()
                dialog.dismiss()
            } else { runOnUiThread {
                Toast.makeText(this@LoginScreenWithApi, getString(R.string.toast_invalid_login),Toast.LENGTH_SHORT).show()
                } }
            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) { response.append(inputLine)
                    inputLine = it.readLine() }
                println("Response : $response")
            }
        }
    }

    fun showDialog() {
        dialog.apply {
            getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(true)
            show()
        }
    }
}