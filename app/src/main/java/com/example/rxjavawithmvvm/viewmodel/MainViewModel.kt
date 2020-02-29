package com.example.rxjavawithmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavawithmvvm.model.MoviesItem
import com.example.rxjavawithmvvm.network.RetrofitWeb
import com.example.rxjavawithmvvm.network.ServiceApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {


    val mutableLiveData = MutableLiveData<ArrayList<MoviesItem>>()
    val compositeDisposable = CompositeDisposable()

    fun getAllMovies() {


        val disposable = RetrofitWeb.getClient()!!.create(ServiceApi::class.java)
            .getMovies("seeds", 15)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                mutableLiveData.value = it.data?.movies
            }

        compositeDisposable.add(disposable)

    }

    fun getLiveData(): LiveData<ArrayList<MoviesItem>> {
        return mutableLiveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}



