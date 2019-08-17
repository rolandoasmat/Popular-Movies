package com.asmat.rolando.popularmovies.ui.topratedmovies

import androidx.lifecycle.ViewModelProviders
import com.asmat.rolando.popularmovies.ui.common.MovieGridFragment
import com.asmat.rolando.popularmovies.viewmodels.ViewModelFactory

class TopRatedMoviesFragment : MovieGridFragment() {

    override val viewModel: TopRatedMoviesViewModel
        get() = ViewModelProviders.of(this, ViewModelFactory(moviesRepository, peopleRepository)).get(TopRatedMoviesViewModel::class.java)

}