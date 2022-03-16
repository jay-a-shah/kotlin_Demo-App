package com.example.demoappkotlin.listviewpager.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.demoappkotlin.R
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.MVP.View.Model.ModelRecyclerWithApi
import com.example.demoappkotlin.MVP.View.Model.UserData
import com.example.demoappkotlin.WebServices.SingleUserInterface

import com.squareup.picasso.Picasso

class RecyclerViewWithApiAdapter(var list: ArrayList<UserData>, private val onClickOfInterface: SingleUserInterface) :
    RecyclerView.Adapter<RecyclerViewWithApiAdapter.RecyclerViewWithApiHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewWithApiHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_with_api, parent, false)
        return RecyclerViewWithApiHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewWithApiHolder, position: Int) {
        val listData = list[position]
        holder.apply {
            setIsRecyclable(false)
            firstName?.text = listData.firstName
            Picasso.get().load(listData.avatar).into(imgView)
            email?.text = listData.email
            layout.setOnClickListener {
                onClickOfInterface.onUserClicked(listData.id)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    class RecyclerViewWithApiHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName: TextView? = itemView.findViewById(R.id.firstNameInRecycler)
        var imgView: ImageView? = itemView.findViewById(R.id.imageViewInRecyclerViewWithApi)
        var email: TextView? = itemView.findViewById(R.id.emailInRecycler)
        var layout: ConstraintLayout = itemView.findViewById(R.id.recyclerViewWithApiLayout)
    }
}

