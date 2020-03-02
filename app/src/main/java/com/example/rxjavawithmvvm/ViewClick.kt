package com.example.rxjavawithmvvm

import com.example.rxjavawithmvvm.model.MoviesItem

interface ViewClick {

    fun moveToMovieDetails(moviesItem: MoviesItem)
}