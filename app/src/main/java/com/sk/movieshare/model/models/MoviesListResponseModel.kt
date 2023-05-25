package com.sk.movieshare.model.models

import com.squareup.moshi.Json

data class MoviesListResponseModel(@field:Json(name = "results") val results:List<MovieResults>)
