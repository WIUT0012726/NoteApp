package com.example.mynavigationsample.detailedView

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.MovieService
import com.example.mynavigationsample.network.RetrofitInstance
import com.example.mynavigationsample.network.movie.MovieRequest
import com.example.mynavigationsample.network.myResponse.MyItemResponse
import com.example.mynavigationsample.network.myResponse.MyResponse
import com.example.mynavigationsample.utils.Constants
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailedViewModel(movieId: String) : ViewModel() {

    val movieLiveData: MutableLiveData<Movie> by lazy {
        MutableLiveData<Movie>()
    }

    init {
        getMovieByIdFromRemoteDb(movieId)
    }

    fun getMovieByIdFromRemoteDb(movieId: String) {
        viewModelScope.launch {
            try {
                val response: MyItemResponse<Movie> =
                    RetrofitInstance.movieService.getOneMovieById(movieId, Constants.STUDENT_ID)
                val movieFromResponse = response.data

                if (movieFromResponse != null) {
                    movieLiveData.value = movieFromResponse
                }


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun editMovieById(movie: Movie) {
        viewModelScope.launch {
            try {

                val response: MyResponse = RetrofitInstance.movieService.updateOneMovieById(
                    movie.id,
                    Constants.STUDENT_ID,
                    MovieRequest(movie.name, movie.description)
                )

                Log.d("Update_response", response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}