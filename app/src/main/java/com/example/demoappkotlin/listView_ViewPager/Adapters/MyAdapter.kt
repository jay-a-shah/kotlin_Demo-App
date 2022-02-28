package com.example.demoappkotlin.listView_ViewPager.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelList
import com.example.demoappkotlin.utils.ZERO

class MyAdapter(val context: Context, val list: ArrayList<ModelList>) : BaseAdapter() {
    private var contactList = arrayListOf<ModelList>()

    init {
        contactList = list
    }

    override fun getCount(): Int {
        return list.count()
    }

    override fun getItem(p0: Int): Any {
        return ZERO
    }

    override fun getItemId(p0: Int): Long {
        return ZERO.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = LayoutInflater.from(context).inflate(R.layout.custom_list_layout, parent, false)
        val holder: listViewHolder = listViewHolder(rowView)
        holder.apply {
            title?.text = contactList[position].name
            desc?.text = contactList[position].desc
            image?.setImageResource(contactList[position].image)
        }
        return rowView
    }

    private class listViewHolder(view: View?) {
        var title: TextView? = view?.findViewById(R.id.tvContactName)
        var desc: TextView? = view?.findViewById(R.id.tvContactDescription)
        var image: ImageView? = view?.findViewById(R.id.contactIcon)
    }
}