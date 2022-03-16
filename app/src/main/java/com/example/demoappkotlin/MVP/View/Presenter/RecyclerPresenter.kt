package com.example.demoappkotlin.MVP.View.Presenter

import android.util.Log
import com.example.demoappkotlin.MVP.View.Model.ModelRecyclerWithApi
import com.example.demoappkotlin.utils.BaseURL
import com.example.demoappkotlin.utils.ENDPOINTRECYCLERVIEW
import com.example.demoappkotlin.utils.REQUESTMETHODGET
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class RecyclerPresenter : IRecyclerView {
    lateinit var view: Irecycler

    override fun getResponseMethod(irecxycler: Irecycler) {
        GlobalScope.launch(Dispatchers.IO) {
            val url = URL("$BaseURL$ENDPOINTRECYCLERVIEW")
            val httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.apply {
                setRequestProperty("Accept", "application/json")
                requestMethod = REQUESTMETHODGET
                doInput = true
                doOutput = false
            }
            val responseCode = httpURLConnection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = httpURLConnection.inputStream.bufferedReader().use { it.readText() }
                withContext(Dispatchers.Main) {
                    view.hideProgressBar()
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    var dataClass = gson.fromJson(response, ModelRecyclerWithApi::class.java)
                    Log.d("Pretty Printed JSON :", dataClass.toString())
                    dataClass.data?.let { irecxycler.getDataClass(it) }
                }
            } else {
                Log.e("HTTPURLCONNECTION_ERROR", responseCode.toString())
            }
        }
    }
}