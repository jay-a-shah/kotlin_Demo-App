package com.example.demoappkotlin.MVP.View.Presenter

import android.util.Log
import com.example.demoappkotlin.MVP.View.Model.ModelRecyclerWithApi
import com.example.demoappkotlin.utils.BaseURL
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class RecyclerPresenter: IRecyclerView {
    override fun getResponseMethod(irecxycler:Irecycler){
        GlobalScope.launch(Dispatchers.IO) {
            val url = URL("$BaseURL/api/users?page=2")
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.setRequestProperty(
                "Accept",
                "application/json"
            ) // The format of response we want to get from the server
            httpURLConnection.requestMethod = "GET"
            httpURLConnection.doInput = true
            httpURLConnection.doOutput = false
            // Check if the connection is successful
            val responseCode = httpURLConnection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = httpURLConnection.inputStream.bufferedReader()
                    .use { it.readText() }  // defaults to UTF-8
                withContext(Dispatchers.Main) {
                    // Convert raw JSON to pretty JSON using GSON library
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(JsonParser.parseString(response))
                    var dataClass = gson.fromJson(response, ModelRecyclerWithApi::class.java)
                    Log.d("Pretty Printed JSON :", dataClass.toString())
//                    newList = arrayListOf()
//                    // modelRecyclerWithApi = ModelRecyclerWithApi(dataClass)
//                    for (user in dataClass.data) {
//                        newList.add(user)
//                    }
                    dataClass.data?.let { irecxycler.getDataClass(it) }
                }
            } else {
                Log.e("HTTPURLCONNECTION_ERROR", responseCode.toString())

            }
        }
    }

    override fun showProgressBar() {
       // progressBarForRecycler.visibility = View.VISIBLE
    }

    override fun createUserActivity() {
//        btnfab.setOnClickListener {
//            val intent = Intent(this, CreateUserActivity::class.java)
//            startActivity(intent)
//        }
    }
}