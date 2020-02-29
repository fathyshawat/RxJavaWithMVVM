package com.example.rxjavawithmvvm.network

import com.example.rxjavawithmvvm.model.Movies
import com.example.rxjavawithmvvm.model.MoviesItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET(Urls.myEndPoint)
    fun getMovies(@Query(Urls.sort)sort:String,@Query(Urls.limit)limit:Int): Observable<Movies>


}