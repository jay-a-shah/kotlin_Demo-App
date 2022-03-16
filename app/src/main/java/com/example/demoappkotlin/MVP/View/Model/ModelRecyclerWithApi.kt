package com.example.demoappkotlin.MVP.View.Model

data class ModelRecyclerWithApi(
    val data: ArrayList<UserData>? = null,
    val page: Int? = null,
    val per_page: Int? = null,
    val support: Support? = null,
    val total: Int? = null,
    val total_pages: Int? = null,
)
data class UserData(
        val avatar: String = "",
        val email: String = "",
        val first_name: String = "",
        val id: Int = 1,
        val last_name: String = ""
    )
data class Support(
        val text: String = "",
        val url: String = ""
    )
