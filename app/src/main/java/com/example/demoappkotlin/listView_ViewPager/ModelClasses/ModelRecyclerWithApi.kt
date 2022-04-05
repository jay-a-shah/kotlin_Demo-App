package com.example.demoappkotlin.listView_ViewPager.ModelClasses

data class ModelRecyclerWithApi(
    val data: ArrayList<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int,
)
{
    data class Data(
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
}