package com.sk.movieshare.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sk.movieshare.model.models.MovieResults

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieResults: MovieResults)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movieResultsList: List<MovieResults>)

    @Query("SELECT * FROM MovieResults")
    fun getMovieResults(): LiveData<List<MovieResults>>
}