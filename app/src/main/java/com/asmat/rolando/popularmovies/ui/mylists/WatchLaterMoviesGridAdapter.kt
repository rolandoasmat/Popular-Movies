package com.asmat.rolando.popularmovies.ui.mylists

import com.asmat.rolando.popularmovies.R
import com.asmat.rolando.popularmovies.ui.common.MovieAdapterOnClickHandler
import com.asmat.rolando.popularmovies.ui.common.BaseMoviesGridAdapter

class WatchLaterMoviesGridAdapter(handler: MovieAdapterOnClickHandler) : BaseMoviesGridAdapter(handler) {

    override val emptyStateLayoutID: Int
        get() = R.layout.empty_state_watch_later

}