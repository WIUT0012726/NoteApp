package com.example.mynavigationsample.detailedView

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.MovieService
import com.example.mynavigationsample.network.RetrofitInstance
import com.example.mynavigationsample.network.movie.MovieRequest
import com.example.mynavigationsample.network.movie.MovieResponse
import com.example.mynavigationsample.network.movie.MovieResponseActorItem
import com.example.mynavigationsample.network.myResponse.MyItemResponse
import com.example.mynavigationsample.network.myResponse.MyResponse
import com.example.mynavigationsample.utils.Constants
import com.example.mynavigationsample.utils.extractListOfActorsFromResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailedViewModel(movieId: String) : ViewModel() {

    val movieLiveData: MutableLiveData<Movie> by lazy {
        MutableLiveData<Movie>()
    }

    init {
        getMovieByIdFromRemoteDb(movieId)
//        deleteOneMovieById("109")
    }

    fun getMovieByIdFromRemoteDb(movieId: String) {
        viewModelScope.launch {
            try {
                val response: MyItemResponse<MovieResponse> =
                    RetrofitInstance.movieService.getOneMovieById(movieId, Constants.STUDENT_ID)
                val movieFromResponse = response.data

                if (movieFromResponse != null) {
                    movieLiveData.value = Movie(
                        movieFromResponse.id,
                        movieFromResponse.name,
                        movieFromResponse.description,
                        extractListOfActorsFromResponse(movieFromResponse.actors),
                        movieFromResponse.budget
                    )
                }


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun editMovieById(movieId: String, movieRequest: MovieRequest) {
        viewModelScope.launch {
            try {

                val response: MyResponse = RetrofitInstance.movieService.updateOneMovieById(
                    movieId,
                    Constants.STUDENT_ID,
                    movieRequest
                )

                Log.d("Update_response", response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteOneMovieById(movieId: String) {
        viewModelScope.launch {
            try {

                val response: MyResponse = RetrofitInstance.movieService.deleteOneMovieById(
                    movieId,
                    Constants.STUDENT_ID
                )

                Log.d("Delete_response", response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}