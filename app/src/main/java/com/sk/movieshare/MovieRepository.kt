package com.sk.movieshare

import android.app.Application
import androidx.lifecycle.LiveData
import com.sk.movieshare.base.Resource
import com.sk.movieshare.model.local.MovieDAO
import com.sk.movieshare.model.models.MovieResults
import com.sk.movieshare.model.models.MoviesListResponseModel
import com.sk.movieshare.model.remote.MovieApi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MovieRepository @Inject constructor(val movieApi: MovieApi,val context: Application,val dao: MovieDAO):MovieRepositoryInterface{

     override suspend fun getMovieList(): Resource<MoviesListResponseModel> {
        return try {
            Resource.Success(
                data = movieApi.getNowPlayingMovieList(
                    apiKey = context.getString(R.string.api_key)
                )
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: context.getString(R.string.server_error))
        }
    }

    override suspend fun insertMovie(movie: MovieResults) {
        dao.insertMovie(movie)
    }

    override suspend fun insertMovies(movies: List<MovieResults>) {
        dao.insertMovies(movies)
    }

    override suspend fun getMovies(): LiveData<List<MovieResults>> {
       return dao.getMovieResults()
    }
}