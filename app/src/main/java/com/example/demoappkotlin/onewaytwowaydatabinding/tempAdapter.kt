package com.example.demoappkotlin.onewaytwowaydatabinding

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.databinding.ItemRecyclerViewBinding

class tempAdapter(private var list: ArrayList<ImageResponseModel>): RecyclerView.Adapter<tempAdapter.MainViewHolder>() {

    private var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
       val binding = ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val tempList = list[position]
        holder.apply {
            textview.text = tempList.basePrice.toString()
            binding.dataClass = tempList
        }
//        holder.textview.text = data
//            Picasso.get().load(movie.imageUrl).into(holder.imgView)
    }
    override fun getItemCount(): Int {
        return list.size
    }
    class MainViewHolder(val binding: ItemRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        var textview: TextView = itemView.findViewById(R.id.textViewInRecycler)
        var imgView : ImageView = itemView.findViewById(R.id.imageViewInRecycler)
    }
}
//class TempRecyclerAdapter(private var imageList: ArrayList<ImageUrlList>) :
//    RecyclerView.Adapter<TempRecyclerAdapter.tempViewHolder>() {
//    private var context: Context? = null
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempRecyclerAdapter.tempViewHolder {
//        context = parent.context
//        val binding =  RecyclerviewItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return TempRecyclerAdapter.tempViewHolder(binding)
//    }
//    override fun onBindViewHolder(holder: tempViewHolder, position: Int) {
//    }
//    override fun getItemCount(): Int {
//        return  imageList.size
//    }
//    class tempViewHolder(val binding: RecyclerviewItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
//        val imgView: ImageView? = itemView.findViewById(R.id.recylerview_img)
//        val txtname: TextView? = itemView.findViewById(R.id.txtview_name_recyclerview)
//        val checkbx: CheckBox? = itemView.findViewById(R.id.chcx_recylerview)
//    }
//}