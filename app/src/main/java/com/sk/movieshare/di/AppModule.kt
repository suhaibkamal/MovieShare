package com.sk.movieshare.di

import android.app.Application
import androidx.room.Room
import com.sk.movieshare.MovieRepository
import com.sk.movieshare.MovieRepositoryInterface
import com.sk.movieshare.model.local.MovieDAO
import com.sk.movieshare.model.local.MovieDatabase
import com.sk.movieshare.model.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "movie_db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideMovieApi():MovieApi{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieDatabase): MovieDAO {
        return db.movieDAO
    }
}