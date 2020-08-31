package com.asmat.rolando.nightwing.di.components

import com.asmat.rolando.nightwing.cast_details.CastDetailsFragment
import com.asmat.rolando.nightwing.di.modules.ContextModule
import com.asmat.rolando.nightwing.di.modules.DatabaseModule
import com.asmat.rolando.nightwing.di.modules.NetworkModule
import com.asmat.rolando.nightwing.di.modules.RepositoriesModule
import com.asmat.rolando.nightwing.cast_details.CastMovieCreditsFragment
import com.asmat.rolando.nightwing.ui.moviegrid.BaseMovieGridFragment
import com.asmat.rolando.nightwing.ui.moviegrid.paginated.PaginatedMovieGridFragment
import com.asmat.rolando.nightwing.movie_details.MovieDetailsFragment
import com.asmat.rolando.nightwing.ui.popularmovies.PopularMoviesFragment
import com.asmat.rolando.nightwing.search.SearchFragment
import com.asmat.rolando.nightwing.ui.discover.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ContextModule::class,
    DatabaseModule::class,
    NetworkModule::class,
    RepositoriesModule::class])
interface ApplicationComponent {

    fun inject(app: MainActivity)
    fun inject(fragment: PopularMoviesFragment)
    fun inject(castDetailsActivity: CastMovieCreditsFragment)
    fun inject(paginatedMovieGridFragment: PaginatedMovieGridFragment)
    fun inject(baseMovieGridFragment: BaseMovieGridFragment)

    fun inject(searchFragment: SearchFragment)
    fun inject(movieDetailsFragment: MovieDetailsFragment)
    fun inject(castDetailsFragment: CastDetailsFragment)

}