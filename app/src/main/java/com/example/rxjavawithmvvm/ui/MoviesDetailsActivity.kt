package com.example.rxjavawithmvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.rxjavawithmvvm.R
import com.example.rxjavawithmvvm.databinding.MovieDetailsBinding
import com.example.rxjavawithmvvm.model.MovieDetails
import com.example.rxjavawithmvvm.model.MoviesItem

class MoviesDetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val moviesItem = intent.getSerializableExtra("object") as MoviesItem
        val generesList = moviesItem.genres!!
        val generes = StringBuilder()
        for (item in generesList) {

            generes.append(item).append(" ")
        }

        val movieDetails = MovieDetails(
            moviesItem.largeCoverImage.toString(), moviesItem.titleEnglish.toString(),
            generes.toString(), moviesItem.year.toString(),
            moviesItem.rating.toString(), moviesItem.synopsis.toString()
        )

        val binding: MovieDetailsBinding =
            DataBindingUtil.setContentView(this, R.layout.movie_details)
        binding.setVariable(1, movieDetails)
        binding.executePendingBindings()
    }
}