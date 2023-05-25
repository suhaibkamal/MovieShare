package com.sk.movieshare.model.remote

import com.sk.movieshare.model.models.MoviesListResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovieList(@Query("api_key") apiKey:String) : MoviesListResponseModel
}