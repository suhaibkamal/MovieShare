package com.sk.movieshare

import androidx.lifecycle.LiveData
import com.sk.movieshare.base.Resource
import com.sk.movieshare.model.models.MovieResults
import com.sk.movieshare.model.models.MoviesListResponseModel

interface MovieRepositoryInterface {
    suspend fun getMovieList(): Resource<MoviesListResponseModel>
    suspend fun insertMovie(movie: MovieResults)
    suspend fun insertMovies(movies: List<MovieResults>)
    suspend fun getMovies():LiveData<List<MovieResults>>
}
