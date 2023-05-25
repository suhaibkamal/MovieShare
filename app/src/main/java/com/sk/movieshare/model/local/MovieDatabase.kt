package com.sk.movieshare.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sk.movieshare.model.models.MovieResults

@Database(
    entities = [MovieResults::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract val movieDAO:MovieDAO;
}