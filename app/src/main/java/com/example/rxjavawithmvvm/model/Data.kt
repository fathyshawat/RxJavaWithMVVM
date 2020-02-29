package com.example.rxjavawithmvvm.model

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("movies")
	val movies: ArrayList<MoviesItem>? = null,

	@field:SerializedName("page_number")
	val pageNumber: Int? = null,

	@field:SerializedName("movie_count")
	val movieCount: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null
)