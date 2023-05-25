package com.sk.movieshare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sk.movieshare.MoviesAdapter.MovieClickListener
import com.sk.movieshare.base.BaseActivity
import com.sk.movieshare.base.BaseViewModel
import com.sk.movieshare.databinding.ActivityMoviesBinding
import com.sk.movieshare.model.models.MovieResults
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : BaseActivity<ActivityMoviesBinding>() {

    val movieViwModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        movieViwModel.loadMovieList()

        movieViwModel.moviesLiveData.observe(this){
            findViewById<RecyclerView>(R.id.rv_movies).layoutManager = LinearLayoutManager(this)
            findViewById<RecyclerView>(R.id.rv_movies).adapter =
                MoviesAdapter(this,it.results, listener = object : MovieClickListener {
                    override fun onClick(movie: MovieResults?) {

                        share(movie)
                    }
                })
        }
    }

    private fun share(movie: MovieResults?) {

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, movie?.title)
            putExtra(Intent.EXTRA_STREAM, "https://image.tmdb.org/t/p/w500"+movie?.posterPath)
            type = "image/*"

        }

        startActivity(sendIntent)

    }

    override fun getLayout(): Int {
        return R.layout.activity_movies
    }



}