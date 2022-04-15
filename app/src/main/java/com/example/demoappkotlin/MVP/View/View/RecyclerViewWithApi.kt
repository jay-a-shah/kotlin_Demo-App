package com.example.demoappkotlin.MVP.View.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoappkotlin.MVP.View.Model.ModelRecyclerWithApi
import com.example.demoappkotlin.MVP.View.Presenter.IRecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.WebServices.CreateUserActivity
import com.example.demoappkotlin.WebServices.SingleUserActivity
import com.example.demoappkotlin.WebServices.SingleUserInterface
import com.example.demoappkotlin.listView_ViewPager.Adapters.RecyclerViewWithApiAdapter
import com.example.demoappkotlin.utils.BaseURL
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_recycler_view_with_api.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class RecyclerViewWithApi : AppCompatActivity(), SingleUserInterface , IRecyclerView {

    lateinit var dataClass: ModelRecyclerWithApi
   //private lateinit var newList: ArrayList<ModelRecyclerWithApi.Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_api)
     showProgressBar()
       createUserActivity()
        recyclerViewWithApi.layoutManager = LinearLayoutManager(this)
        getResponseMethod()
    }



    override fun onUserClicked(position: Int) {
        val intent = Intent(this, SingleUserActivity::class.java)
        intent.putExtra("Selected User",position)
        startActivity(intent)
    }

    override fun getResponseMethod() {
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
                    dataClass = gson.fromJson(response, ModelRecyclerWithApi::class.java)
                    progressBarForRecycler.visibility = View.GONE
                    Log.d("Pretty Printed JSON :", dataClass.toString())
//                    newList = arrayListOf()
//                    // modelRecyclerWithApi = ModelRecyclerWithApi(dataClass)
//                    for (user in dataClass.data) {
//                        newList.add(user)
//                    }

                    val adapter = RecyclerViewWithApiAdapter(dataClass.data,this@RecyclerViewWithApi)

                    recyclerViewWithApi.adapter = adapter
                }
            } else {
                Log.e("HTTPURLCONNECTION_ERROR", responseCode.toString())
            }
        }
    }

    override fun showProgressBar() {
        progressBarForRecycler.visibility = View.VISIBLE
    }

    override fun createUserActivity() {
        btnFab.setOnClickListener {
            val intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)
        }
    }
}
