package com.asmat.rolando.nightwing.model

import com.asmat.rolando.nightwing.networking.TheMovieDBClient
import com.asmat.rolando.nightwing.networking.models.MoviesResponse
import io.reactivex.Single
import io.reactivex.Scheduler

data class NowPlayingPaginatedRequest(private val tmdbClient: TheMovieDBClient,
                                      private val computationScheduler: Scheduler,
                                      override val mainThreadScheduler: Scheduler) : PaginatedRequest<MoviesResponse.Movie>(mainThreadScheduler){

    override fun fetchData(pageToLoad: Int): Single<PagedData<MoviesResponse.Movie>> {
        return tmdbClient
                .getNowPlayingMovies(pageToLoad)
                .subscribeOn(computationScheduler)
                .map { PagedData(it.results ?: emptyList(), it.total_pages ?: 0) }
    }

}