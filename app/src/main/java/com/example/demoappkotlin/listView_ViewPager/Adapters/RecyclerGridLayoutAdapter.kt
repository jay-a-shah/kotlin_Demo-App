package com.example.demoappkotlin.listView_ViewPager.Adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.R
import com.example.demoappkotlin.listView_ViewPager.ModelClasses.ModelRecycleGridLayout

class RecyclerGridLayoutAdapter(val list:ArrayList<ModelRecycleGridLayout>): RecyclerView.Adapter<RecyclerGridLayoutAdapter.RecycleViewGridLayoutHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewGridLayoutHolder {
        val itemValue = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_grid_layout, parent, false)
        return RecycleViewGridLayoutHolder(itemValue)
    }

    override fun onBindViewHolder(holder: RecycleViewGridLayoutHolder, position: Int
    ) {
        val listData = list[position]
       holder.txtView?.text = listData.title
        holder.descView?.text = listData.desc
        holder.imgView?.setImageResource(listData.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class RecycleViewGridLayoutHolder(item: View):RecyclerView.ViewHolder(item){
        var txtView: TextView? = item.findViewById(R.id.textViewCardView)
        var descView: TextView? = item.findViewById(R.id.descCardView)
        var imgView: ImageView? = item.findViewById(R.id.imageViewCardView)
    }
}