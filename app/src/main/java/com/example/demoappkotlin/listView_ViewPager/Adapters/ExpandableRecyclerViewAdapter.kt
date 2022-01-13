package com.example.demoappkotlin.listView_ViewPager.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelExpandableRecyclerView

class ExpandableRecyclerViewAdapter(var list: ArrayList<ModelExpandableRecyclerView>) :
    RecyclerView.Adapter<ExpandableRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expandable_recycler_view, parent, false)
        return MyViewHolder(itemview)

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        val isvisible: Boolean = currentItem.visibility
        holder.apply {
            image.setImageResource(currentItem.img)
            title.text = currentItem.title
            brief.text = currentItem.desc
            constraintLayout.visibility = if (isvisible) View.VISIBLE else View.GONE
            title.setOnClickListener {
                currentItem.visibility = !currentItem.visibility
                notifyItemChanged(position)
            }
        }
    }
    override fun getItemCount(): Int {
        return list.count()
    }

    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val image: ImageView = itemview.findViewById(R.id.imageViewExpandableRecycler)
        val title: TextView = itemview.findViewById(R.id.textViewExpandableRecycler)
        val brief: TextView = itemview.findViewById(R.id.tvExpandedRecyclerView)
        val constraintLayout: ConstraintLayout = itemview.findViewById(R.id.expandedLayout)
    }
}