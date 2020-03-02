package com.example.rxjavawithmvvm.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavawithmvvm.ViewClick
import com.example.rxjavawithmvvm.databinding.ItemMovieBinding
import com.example.rxjavawithmvvm.model.MoviesItem


class MoviesAdapter(var context: Context) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    var viewClick: ViewClick? = null
    val movies = ArrayList<MoviesItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemMovieBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies.get(position)!!, viewClick!!)
    }

    fun addMovies(movie: ArrayList<MoviesItem>) {
        movies.addAll(movie)
        notifyDataSetChanged()
    }

    fun clickAdapter(viewClick: ViewClick) {
        this.viewClick = viewClick
    }

    class ViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MoviesItem, viewClick: ViewClick) {
            binding.movie = item
            binding.click = viewClick
            binding.executePendingBindings()
        }
    }

}