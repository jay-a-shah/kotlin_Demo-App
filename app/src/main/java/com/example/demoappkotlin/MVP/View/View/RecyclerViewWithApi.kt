package com.example.demoappkotlin.MVP.View.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoappkotlin.MVP.View.Model.UserData
import com.example.demoappkotlin.MVP.View.Presenter.Irecycler
import com.example.demoappkotlin.MVP.View.Presenter.RecyclerPresenter
import com.example.demoappkotlin.R
import com.example.demoappkotlin.WebServices.SingleUserActivity
import com.example.demoappkotlin.WebServices.SingleUserInterface
import com.example.demoappkotlin.listviewpager.Adapters.RecyclerViewWithApiAdapter
import kotlinx.android.synthetic.main.activity_recycler_view_with_api.*

class RecyclerViewWithApi : AppCompatActivity(), SingleUserInterface, Irecycler{

   // private lateinit var newList: ArrayList<ModelRecyclerWithApi.Data>
    override fun onCreate(savedInstanceState: Bundle?) {
       var presenter = RecyclerPresenter()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_api)
//        showProgressBar()
//        createUserActivity()
        recyclerViewWithApi.layoutManager = LinearLayoutManager(this)
       presenter.getResponseMethod(this)


    }




    override fun onUserClicked(position: Int) {
        val intent = Intent(this, SingleUserActivity::class.java)
        intent.putExtra("Selected User",position)
        startActivity(intent)
    }

    override fun getDataClass(dataClass: ArrayList<UserData>) {
        val adapter = RecyclerViewWithApiAdapter(dataClass,this@RecyclerViewWithApi)
        recyclerViewWithApi.adapter = adapter
    }


}
