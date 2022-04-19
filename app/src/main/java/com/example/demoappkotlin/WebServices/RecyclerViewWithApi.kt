package com.example.demoappkotlin.WebServices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoappkotlin.MVP.View.Model.ModelRecyclerWithApi
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.Adapters.RecyclerViewWithApiAdapter
import com.example.demoappkotlin.utils.BaseURL
import com.example.demoappkotlin.utils.ENDPOINTRECYCLERVIEW
import com.example.demoappkotlin.utils.REQUESTMETHODGET
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_recycler_view_with_api.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class RecyclerViewWithApi : AppCompatActivity(),SingleUserInterface {
    lateinit var dataClass: ModelRecyclerWithApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_api)
        progressBarForRecycler.visibility = View.VISIBLE
        btnFab.setOnClickListener {
            val intent = Intent(this,CreateUserActivity::class.java)
            startActivity(intent)
        }
        recyclerViewWithApi.layoutManager = LinearLayoutManager(this)
        getMethod()
    }

    fun getMethod() {
        GlobalScope.launch(Dispatchers.IO) {
            val url = URL("$BaseURL$ENDPOINTRECYCLERVIEW")
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.apply {
                setRequestProperty("Accept", "application/json")
                requestMethod = REQUESTMETHODGET
                doInput = true
                doOutput = false
            } // The format of response we want to get from the server
            // Check if the connection is successful
            val responseCode = httpURLConnection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = httpURLConnection.inputStream.bufferedReader()
                    .use { it.readText() }  // defaults to UTF-8
                withContext(Dispatchers.Main) {
                    // Convert raw JSON to pretty JSON using GSON library
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(JsonParser.parseString(response))
                    dataClass = gson.fromJson(response, ModelRecyclerWithApi::class.java)
                    progressBarForRecycler.visibility = View.GONE
                    Log.d("Pretty Printed JSON :", dataClass.toString())
                    val adapter = dataClass.data?.let { RecyclerViewWithApiAdapter(it, this@RecyclerViewWithApi)}
                    recyclerViewWithApi.adapter = adapter
                }
            } else {
                Log.e("HTTPURLCONNECTION_ERROR", responseCode.toString())
            }
        }
    }

    override fun onUserClicked(position: Int) {
      Intent(this,SingleUserActivity::class.java).apply {
          putExtra("Selected User",position)
          startActivity(this)
      }
    }
}
