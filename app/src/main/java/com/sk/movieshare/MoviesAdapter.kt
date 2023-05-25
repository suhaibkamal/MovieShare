package com.sk.movieshare

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sk.movieshare.model.models.MovieResults

class MoviesAdapter( val context:Context, val movies:List<MovieResults>,val listener:MovieClickListener): RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {



    inner class MovieViewHolder(itemView: View) : ViewHolder(itemView) {

        var tvMovieName: TextView? = null
        var ivMovie: ImageView? = null
        var tvRate: TextView? = null
        var tvDetails: TextView? = null

        init {
            tvMovieName = itemView.findViewById(R.id.title)
            ivMovie = itemView.findViewById(R.id.iv_movie)
            tvRate = itemView.findViewById(R.id.rating)
            tvDetails = itemView.findViewById(R.id.details)
            itemView.setOnClickListener {
                listener.onClick(
                    movies.get(
                       adapterPosition
                    )
                )
            }
        }

        open fun bind(movie: MovieResults) {
            tvRate?.text= movie.voteAverage.toString()
            tvMovieName?.text=movie.title
            tvDetails?.text=movie.overview
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+movie.posterPath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivMovie!!)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.row_movie, parent, false)

        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.bind(movies.get(position))

    }


    interface MovieClickListener {
        fun onClick(movie: MovieResults?)
    }
}