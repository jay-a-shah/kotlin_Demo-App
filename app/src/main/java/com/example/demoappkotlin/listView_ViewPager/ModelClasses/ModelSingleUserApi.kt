package com.example.demoappkotlin.listView_ViewPager.ModelClasses

import com.example.demoappkotlin.MVP.View.Model.ModelRecyclerWithApi

data class ModelSingleUserApi(
    val data: ModelRecyclerWithApi.Data?,
    val support: ModelRecyclerWithApi.Support?
)