package com.example.mynavigationsample.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.MovieService
import com.example.mynavigationsample.network.myResponse.MyItemResponse
import com.example.mynavigationsample.network.RetrofitInstance
import com.example.mynavigationsample.network.myResponse.MyListResponse
import com.example.mynavigationsample.network.myResponse.MyResponse
import com.example.mynavigationsample.utils.Constants
import kotlinx.coroutines.launch
import java.lang.Exception

class ListViewModel : ViewModel() {

    val moviesLiveData: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>()
    }

    init {
         getListOfMoviesFromRemoteDb()
    }

    fun getListOfMoviesFromRemoteDb() {
        viewModelScope.launch {
            try {
                val retrofitInstance = RetrofitInstance
                    .getRetrofitInstance()
                    .create(MovieService::class.java)

                val response: MyListResponse<Movie> = retrofitInstance.getAllMovies("00001428")
                val moviesFromResponse = response.data

                if (moviesFromResponse != null) {
                    moviesLiveData.value = moviesFromResponse
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

     fun deleteOneMovieById(movieId: String) {
        viewModelScope.launch {
            try {
                val retrofitInstance = RetrofitInstance
                    .getRetrofitInstance()
                    .create(MovieService::class.java)

                val response: MyResponse = retrofitInstance.deleteOneMovieById(
                    movieId,
                    Constants.STUDENT_ID
                )

                Log.d("Update_response", response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteAllMovies() {
        //todo
    }
}