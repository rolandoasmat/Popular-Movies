package com.asmat.rolando.nightwing.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.asmat.rolando.nightwing.deep_links.DeepLinksUtils
import com.asmat.rolando.nightwing.model.mappers.DataModelMapper
import com.asmat.rolando.nightwing.model.mappers.UiModelMapper
import com.asmat.rolando.nightwing.repositories.MoviesRepository
import com.asmat.rolando.nightwing.repositories.PeopleRepository
import com.asmat.rolando.nightwing.cast_details.CastDetailsViewModel
import com.asmat.rolando.nightwing.cast_details.PersonMovieCreditsViewModel
import com.asmat.rolando.nightwing.movie_details.MovieDetailsViewModel
import com.asmat.rolando.nightwing.popular_people_tab.PopularPeopleViewModel
import com.asmat.rolando.nightwing.repositories.TvShowsRepository
import com.asmat.rolando.nightwing.saved_movies.SavedMoviesViewModel
import com.asmat.rolando.nightwing.saved_tv_shows.SavedTvShowsViewModel
import com.asmat.rolando.nightwing.ui.nowplayingmovies.NowPlayingMoviesViewModel
import com.asmat.rolando.nightwing.ui.popularmovies.PopularMoviesViewModel
import com.asmat.rolando.nightwing.search.SearchViewModel
import com.asmat.rolando.nightwing.tv_season_details.TvSeasonDetailsViewModel
import com.asmat.rolando.nightwing.tv_show_details.TvShowDetailsViewModel
import com.asmat.rolando.nightwing.tv_shows_tab.TvShowsTabViewModel
import com.asmat.rolando.nightwing.tv_shows_tab.on_the_air.OnTheAirTvShowsViewModel
import com.asmat.rolando.nightwing.tv_shows_tab.popular.PopularTvShowsViewModel
import com.asmat.rolando.nightwing.tv_shows_tab.top_rated.TopRatedTvShowsViewModel
import com.asmat.rolando.nightwing.ui.recommended_movies.RecommendedMoviesViewModel
import com.asmat.rolando.nightwing.ui.topratedmovies.TopRatedMoviesViewModel
import com.asmat.rolando.nightwing.ui.upcomingmovies.UpcomingMoviesViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
        private val moviesRepository: MoviesRepository,
        private val peopleRepository: PeopleRepository,
        private val tvShowsRepository: TvShowsRepository,
        private val dataModelMapper: DataModelMapper,
        private val uiModelMapper: UiModelMapper,
        private val deepLinksUtils: DeepLinksUtils) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PopularMoviesViewModel::class.java) -> PopularMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(TopRatedMoviesViewModel::class.java) -> TopRatedMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(NowPlayingMoviesViewModel::class.java) -> NowPlayingMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(UpcomingMoviesViewModel::class.java) -> UpcomingMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(MovieDetailsViewModel::class.java) -> MovieDetailsViewModel(moviesRepository, peopleRepository, dataModelMapper, deepLinksUtils, AndroidSchedulers.mainThread(), uiModelMapper) as T
            modelClass.isAssignableFrom(CastDetailsViewModel::class.java) -> CastDetailsViewModel(peopleRepository, AndroidSchedulers.mainThread()) as T
            modelClass.isAssignableFrom(PersonMovieCreditsViewModel::class.java) -> PersonMovieCreditsViewModel(peopleRepository, uiModelMapper, AndroidSchedulers.mainThread(), moviesRepository) as T
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> SearchViewModel(moviesRepository, peopleRepository, tvShowsRepository, uiModelMapper) as T
            modelClass.isAssignableFrom(RecommendedMoviesViewModel::class.java) -> RecommendedMoviesViewModel(moviesRepository, uiModelMapper, dataModelMapper) as T
            modelClass.isAssignableFrom(PopularPeopleViewModel::class.java) -> PopularPeopleViewModel(peopleRepository, uiModelMapper) as T
            modelClass.isAssignableFrom(TvShowsTabViewModel::class.java) -> TvShowsTabViewModel(tvShowsRepository, uiModelMapper) as T
            modelClass.isAssignableFrom(PopularTvShowsViewModel::class.java) -> PopularTvShowsViewModel(tvShowsRepository, uiModelMapper) as T
            modelClass.isAssignableFrom(TopRatedTvShowsViewModel::class.java) -> TopRatedTvShowsViewModel(tvShowsRepository, uiModelMapper) as T
            modelClass.isAssignableFrom(OnTheAirTvShowsViewModel::class.java) -> OnTheAirTvShowsViewModel(tvShowsRepository, uiModelMapper) as T
            modelClass.isAssignableFrom(TvShowDetailsViewModel::class.java) -> TvShowDetailsViewModel(tvShowsRepository, uiModelMapper, deepLinksUtils) as T
            modelClass.isAssignableFrom(SavedMoviesViewModel::class.java) -> SavedMoviesViewModel(moviesRepository, uiModelMapper) as T
            modelClass.isAssignableFrom(SavedTvShowsViewModel::class.java) -> SavedTvShowsViewModel(tvShowsRepository, uiModelMapper) as T
            modelClass.isAssignableFrom(TvSeasonDetailsViewModel::class.java) -> TvSeasonDetailsViewModel(tvShowsRepository, uiModelMapper) as T
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }

}