package com.sk.movieshare

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sk.movieshare.base.BaseViewModel
import com.sk.movieshare.base.Resource
import com.sk.movieshare.model.models.MoviesListResponseModel
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor( val repository: MovieRepositoryInterface):BaseViewModel() {

    val moviesLiveData:MutableLiveData<MoviesListResponseModel> = MutableLiveData();
    fun loadMovieList() {
    viewModelScope.launch {
        when(val result = repository.getMovieList()){
            is Resource.Success ->{
                val movieList = result.data?.results;
                if (movieList != null) {
                    repository.insertMovies(movies = movieList)
                }
                moviesLiveData.value = result.data
            }

            is Resource.Error->{

                handleError(Throwable(result.message))
            }
        }
    }
    }
}