package com.asmat.rolando.popularmovies.model

import com.asmat.rolando.popularmovies.networking.the.movie.db.TheMovieDBClient
import com.asmat.rolando.popularmovies.networking.the.movie.db.models.MoviesResponse
import io.reactivex.Single
import io.reactivex.Scheduler

data class TopRatedPaginatedRequest(private val tmdbClient: TheMovieDBClient,
                                    private val computationScheduler: Scheduler,
                                    override val mainThreadScheduler: Scheduler) : PaginatedRequest<MoviesResponse.Movie>(mainThreadScheduler){

    override fun fetchData(pageToLoad: Int): Single<PagedData<MoviesResponse.Movie>> {
        return tmdbClient
                .getTopRatedMovies(pageToLoad)
                .subscribeOn(computationScheduler)
                .map { PagedData(it.results ?: emptyList(), it.total_pages ?: 0) }
    }

}