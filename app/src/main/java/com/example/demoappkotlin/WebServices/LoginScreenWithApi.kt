package com.example.demoappkotlin.WebServices

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demoappkotlin.MVC.View.LoginScreenView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.utils.BaseURL
import kotlinx.android.synthetic.main.activity_login_screen_with_api.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class LoginScreenWithApi : AppCompatActivity(){
     lateinit var dialog : Dialog
     lateinit var loginScreenView: LoginScreenView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen_with_api)
        dialog = Dialog(this)
        btnLoginPage.setOnClickListener {
            Thread {
                try {
                    sendPostRequest(
                        editTextEmailForLogin.text.toString(),
                        editTextPasswordForLogin.text.toString()
                    )
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }.start()
          loginScreenView.showDialog(dialog)
        }
    }

    private fun sendPostRequest(username: String, password: String) {
        val credential = JSONObject()
        credential.put("email", username)
        credential.put("password", password)
        val url = URL("$BaseURL/api/login")
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json")
            val wr = OutputStreamWriter(outputStream)
            wr.write(credential.toString())
            wr.flush()
            println("URL : $url")
            println("cred: $credential")
            println("Response Code: $responseCode")
            if (responseCode == 200) {
                val intent = Intent(applicationContext, RecyclerViewWithApiActivity::class.java)
                startActivity(intent)
                finish()
                dialog.dismiss()
               // progressBarLogin.visibility = View.GONE
            } else {
                runOnUiThread {
                    Toast.makeText(
                        this@LoginScreenWithApi,
                        "InValid Login",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                println("Response : $response")
            }

        }
    }

}