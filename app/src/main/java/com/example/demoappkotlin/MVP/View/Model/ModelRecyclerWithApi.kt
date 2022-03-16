package com.example.demoappkotlin.MVP.View.Model

import com.google.gson.annotations.SerializedName

data class ModelRecyclerWithApi(
    @SerializedName("data")
    val data: ArrayList<UserData>? = null,
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("per_page")
    val perPage: Int? = null,
    @SerializedName("support")
    val support: Support? = null,
    @SerializedName("total")
    val total: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
)

data class UserData(
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("first_name")
    val firstName: String = "",
    @SerializedName("id")
    val id: Int = 1,
    @SerializedName("last_name")
    val lastName: String = ""
)

data class Support(
    @SerializedName("text")
    val text: String = "",
    @SerializedName("url")
    val url: String = ""
)
