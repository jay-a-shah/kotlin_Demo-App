package com.example.demoappkotlin.listviewpager.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R

class ViewPagerThreeAdapter(val img: List<Int>) : RecyclerView.Adapter<ViewPagerThreeAdapter.ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.ivSliderImage.setImageResource(img[position])
    }

    override fun getItemCount(): Int {
        return img.size
    }

    class ViewPagerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivSliderImage = itemView.findViewById<ImageView>(R.id.ivSliderImage)
    }
}