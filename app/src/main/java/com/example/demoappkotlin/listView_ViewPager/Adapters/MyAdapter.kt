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

class MyAdapter(val context: Context,val list:ArrayList<ModelList>): BaseAdapter() {
    private var ContactList = arrayListOf<ModelList>()
    init {
      ContactList = list
    }
    override fun getCount(): Int {
      //to count
        return list.count()
    }

    override fun getItem(p0: Int): Any {
     //To get item
        return 0
    }

    override fun getItemId(p0: Int): Long {
       //to get item
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = LayoutInflater.from(context).inflate(R.layout.custom_list_layout,parent,false)
        val holder: listViewHolder
        holder = listViewHolder(rowView)
        holder.title?.text = ContactList[position].name
        holder.desc?.text = ContactList[position].desc
        holder.image?.setImageResource(ContactList[position].image)
        return rowView
    }
    private class listViewHolder(view: View?) {
        var title: TextView? = view?.findViewById(R.id.contact_name)
        var desc: TextView? = view?.findViewById(R.id.contact_description)
        var image: ImageView? = view?.findViewById(R.id.contact_icon)

    }

}