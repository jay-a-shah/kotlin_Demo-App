package com.example.demoappkotlin.MVP.View.Presenter

import com.example.demoappkotlin.MVP.View.Model.UserData

interface IRecyclerView {
    fun getResponseMethod(irecxycler: Irecycler)
}

interface Irecycler {
    fun getDataClass(dataClass: ArrayList<UserData>)
    fun showProgressBar()
    fun createUserActivity()
    fun hideProgressBar()
}