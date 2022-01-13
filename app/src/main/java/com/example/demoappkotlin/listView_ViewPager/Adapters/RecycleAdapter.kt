package com.example.demoappkotlin.listView_ViewPager.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.demoappkotlin.R
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelRecycle

class RecycleAdapter(var list: ArrayList<ModelRecycle>) :
    RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return RecycleViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val listData = list[position]
        holder.setIsRecyclable(false)
        holder.txtView?.text = listData.name
        holder.imgView?.setImageResource(listData.image)
        holder.chkbxView?.isChecked = listData.check
        holder.chkbxView?.setOnCheckedChangeListener { btn, bool ->
            holder.chkbxView?.isChecked = bool
            listData.check = bool
        }
    }
    override fun getItemCount(): Int {
        return list.count()
    }

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtView: TextView? = itemView.findViewById(R.id.textViewInRecycler)
        var imgView: ImageView? = itemView.findViewById(R.id.imageViewInRecycler)
        var chkbxView: CheckBox? = itemView.findViewById(R.id.checkBoxInRecycler)
    }
}
