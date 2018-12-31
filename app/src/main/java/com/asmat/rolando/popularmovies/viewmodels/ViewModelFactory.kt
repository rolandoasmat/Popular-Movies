package com.asmat.rolando.popularmovies.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.asmat.rolando.popularmovies.model.Movie
import com.asmat.rolando.popularmovies.model.MoviesRepository

class ViewModelFactory(private val moviesRepository: MoviesRepository,
                       private val movieData: Movie) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(moviesRepository, movieData) as T
    }

}