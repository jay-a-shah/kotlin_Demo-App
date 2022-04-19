package com.example.demoappkotlin.listviewpager.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listviewpager.modelclasses.ModelRecycleGridLayout

class RecyclerGridLayoutAdapter(val list: ArrayList<ModelRecycleGridLayout>) : RecyclerView.Adapter<RecyclerGridLayoutAdapter.RecycleViewGridLayoutHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewGridLayoutHolder {
        val itemValue = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_grid_layout, parent, false)
        return RecycleViewGridLayoutHolder(itemValue)
    }

    override fun onBindViewHolder(holder: RecycleViewGridLayoutHolder, position: Int) {
        val listData = list[position]
        holder.apply {
            txtView?.text = listData.title
            descView?.text = listData.desc
            imgView?.setImageResource(listData.image)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class RecycleViewGridLayoutHolder(item: View) : RecyclerView.ViewHolder(item) {
        var txtView: TextView? = item.findViewById(R.id.textViewCardView)
        var descView: TextView? = item.findViewById(R.id.descCardView)
        var imgView: ImageView? = item.findViewById(R.id.imageViewCardView)
    }
}