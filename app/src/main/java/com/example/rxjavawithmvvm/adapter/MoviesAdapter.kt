package com.example.rxjavawithmvvm.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavawithmvvm.databinding.ItemMovieBinding
import com.example.rxjavawithmvvm.model.MoviesItem
import com.squareup.picasso.Picasso


class MoviesAdapter(var context: Context) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    val movies = ArrayList<MoviesItem>()

    init {
        Log.e("adapter123","enter")
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemMovieBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.e("adapter123",movies?.size!!.toString())

        return movies?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies?.get(position)!!)
        Log.e("adapter123", position.toString())
    }

    fun addMovies(movie: ArrayList<MoviesItem>) {
        movies?.addAll(movie)
        notifyDataSetChanged()
    }

    @BindingAdapter("bind:image_url")
    fun setImage(view: ImageView, image_url: String) {
        image_url?.let {
            Picasso.get().load(image_url).into(view)

    }
   }


    class ViewHolder(val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MoviesItem) {
            binding.movie = item
            binding.executePendingBindings()
        }
    }

}