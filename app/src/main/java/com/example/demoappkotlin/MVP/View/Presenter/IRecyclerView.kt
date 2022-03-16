package com.example.demoappkotlin.MVP.View.Presenter

import com.example.demoappkotlin.MVP.View.Model.ModelRecyclerWithApi
import com.example.demoappkotlin.MVP.View.Model.UserData

interface IRecyclerView {
    fun getResponseMethod(irecxycler:Irecycler)
    fun showProgressBar()
    fun createUserActivity()
}
interface Irecycler{
    fun getDataClass(dataClass: ArrayList<UserData>)
}