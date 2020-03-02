package com.example.rxjavawithmvvm.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavawithmvvm.R
import com.example.rxjavawithmvvm.ViewClick
import com.example.rxjavawithmvvm.adapter.MoviesAdapter
import com.example.rxjavawithmvvm.model.MoviesItem
import com.example.rxjavawithmvvm.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewClick {


    private lateinit var mainViewModel: MainViewModel
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        moviesAdapter = MoviesAdapter(this)

        viewManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = viewManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = moviesAdapter

        moviesAdapter.clickAdapter (this)
        mainViewModel.getAllMovies()

        observeMyMovies(mainViewModel)


    }


    fun observeMyMovies(viewModel: MainViewModel) {
        viewModel.getLiveData().observe(this, Observer { it ->
            moviesAdapter.addMovies(it)
        })

    }

    override fun moveToMovieDetails(moviesItem: MoviesItem) {
        val intent = Intent(this, MoviesDetailsActivity::class.java)
        intent.putExtra("object", moviesItem )
        startActivity(intent)
    }

}


