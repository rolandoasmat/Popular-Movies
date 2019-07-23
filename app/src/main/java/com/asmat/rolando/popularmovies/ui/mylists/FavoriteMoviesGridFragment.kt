package com.asmat.rolando.popularmovies.ui.mylists

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.asmat.rolando.popularmovies.model.Movie
import com.asmat.rolando.popularmovies.model.mappers.MovieMapper
import com.asmat.rolando.popularmovies.ui.common.MovieAdapterOnClickHandler
import com.asmat.rolando.popularmovies.ui.common.BaseGridFragment
import com.asmat.rolando.popularmovies.ui.common.BaseMoviesGridAdapter

class FavoriteMoviesGridFragment : BaseGridFragment() {

    override val movieSource: LiveData<List<Movie>>
        get() {
            val source = moviesRepository.getAllFavoriteMovies()
            return Transformations.map(source) { favoriteMovies ->
                favoriteMovies.map {
                    MovieMapper.from(it)
                }
            }
        }

    override fun getAdapter(handler: MovieAdapterOnClickHandler): BaseMoviesGridAdapter {
        return FavoriteMoviesGridAdapter(handler)
    }

}