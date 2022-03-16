package com.example.demoappkotlin.mvvm.ViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappkotlin.mvvm.model.Movie
import com.example.demoappkotlin.R

class RecyclerMVVMAdapter: RecyclerView.Adapter<RecyclerMVVMAdapter.MainViewHolder>() {
    var movies = mutableListOf<Movie>()

    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_adapter_movie, parent, false)
        return MainViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.textview.text = movie.name
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textview: TextView = itemView.findViewById(R.id.movieName)
    }
}
