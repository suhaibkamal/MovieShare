package com.sk.movieshare.model.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity
data class MovieResults (
    @field:Json(name = "title") val title:String,
    @field:Json(name = "release_date") val release_date:String,
    @field:Json(name = "poster_path") val posterPath:String,
    @field:Json(name = "overview") val overview:String,
    @field:Json(name = "vote_average") val voteAverage:Double,
    @field:Json(name = "id") @PrimaryKey val id:Int
)
