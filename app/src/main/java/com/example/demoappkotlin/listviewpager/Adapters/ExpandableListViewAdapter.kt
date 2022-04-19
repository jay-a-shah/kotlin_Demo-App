package com.example.demoappkotlin.listviewpager.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.utils.ZERO

class ExpandableListViewAdapter(var context: Context, var headerList: MutableList<String>, var childList: HashMap<String, List<String>>) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return headerList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return this.childList[this.headerList[p0]]?.count() ?: ZERO
    }

    override fun getGroup(groupPosition: Int): String {
        return headerList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return this.childList[this.headerList[groupPosition]]?.get(childPosition) ?: ""
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, convertView: View?, p3: ViewGroup?): View? {
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
            R.layout.item_expandable_header, null).apply {
            val header = this?.findViewById<TextView>(R.id.tvExpandableHeader)
            header?.text = getGroup(p0)
            return this
        }
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, convertView: View?, p4: ViewGroup?): View? {
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
            R.layout.item_expandable_child, null).apply {
            val child = convertView?.findViewById<TextView>(R.id.tvExpandableChild)
            child?.text = getChild(p0, p1)
            return this
        }
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}