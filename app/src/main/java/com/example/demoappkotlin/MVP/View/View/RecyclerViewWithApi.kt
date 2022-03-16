package com.example.demoappkotlin.MVP.View.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoappkotlin.MVP.View.Model.UserData
import com.example.demoappkotlin.MVP.View.Presenter.Irecycler
import com.example.demoappkotlin.MVP.View.Presenter.RecyclerPresenter
import com.example.demoappkotlin.R
import com.example.demoappkotlin.WebServices.CreateUserActivity
import com.example.demoappkotlin.WebServices.SingleUserActivity
import com.example.demoappkotlin.WebServices.SingleUserInterface
import com.example.demoappkotlin.listviewpager.Adapters.RecyclerViewWithApiAdapter
import com.example.demoappkotlin.utils.IntentPutKey
import kotlinx.android.synthetic.main.activity_recycler_view_with_api.btnFab
import kotlinx.android.synthetic.main.activity_recycler_view_with_api.progressBarForRecycler
import kotlinx.android.synthetic.main.activity_recycler_view_with_api.recyclerViewWithApi

class RecyclerViewWithApi : AppCompatActivity(), SingleUserInterface, Irecycler {

    override fun onCreate(savedInstanceState: Bundle?) {
        var presenter = RecyclerPresenter()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_with_api)
        presenter.view = this
        showProgressBar()
        createUserActivity()
        recyclerViewWithApi.layoutManager = LinearLayoutManager(this)
        presenter.getResponseMethod(this)
    }

    override fun onUserClicked(position: Int) {
       Intent(this, SingleUserActivity::class.java).apply {
           putExtra(IntentPutKey, position)
           startActivity(this)
       }
    }

    override fun getDataClass(dataClass: ArrayList<UserData>) {
        val adapter = RecyclerViewWithApiAdapter(dataClass, this@RecyclerViewWithApi)
        recyclerViewWithApi.adapter = adapter
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

    override fun hideProgressBar() {
        progressBarForRecycler.visibility = View.GONE
    }
}
