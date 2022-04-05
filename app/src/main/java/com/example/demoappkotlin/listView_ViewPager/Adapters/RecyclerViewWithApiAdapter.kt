package com.example.demoappkotlin.listView_ViewPager.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.demoappkotlin.R
import androidx.recyclerview.widget.RecyclerView

import com.example.demoappkotlin.listView_ViewPager.ModelClasses.Data
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelRecyclerWithApi

import com.squareup.picasso.Picasso

class RecyclerViewWithApiAdapter(var list: ArrayList<ModelRecyclerWithApi.Data>) :
    RecyclerView.Adapter<RecyclerViewWithApiAdapter.RecyclerViewWithApiHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewWithApiHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_with_api, parent, false)
        return RecyclerViewWithApiHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewWithApiHolder, position: Int) {
        val listData = list[position]
        holder.apply {
            setIsRecyclable(false)
            firstName?.text = listData.first_name
            Picasso.get().load(listData.avatar).into(imgView)
            email?.text = listData.email

        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    class RecyclerViewWithApiHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName: TextView? = itemView.findViewById(R.id.firstNameInRecycler)
        var imgView: ImageView? = itemView.findViewById(R.id.imageViewInRecyclerViewWithApi)
        var email: TextView? = itemView.findViewById(R.id.emailInRecycler)
        var layout : ConstraintLayout = itemView.findViewById(R.id.recyclerViewWithApiLayout)
    }
}
