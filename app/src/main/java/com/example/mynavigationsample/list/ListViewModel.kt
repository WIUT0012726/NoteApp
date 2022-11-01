package com.example.mynavigationsample.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.MovieService
import com.example.mynavigationsample.network.myResponse.MyItemResponse
import com.example.mynavigationsample.network.RetrofitInstance
import com.example.mynavigationsample.network.movie.MovieRequest
import com.example.mynavigationsample.network.myResponse.MyListResponse
import com.example.mynavigationsample.utils.Constants
import kotlinx.coroutines.launch
import java.lang.Exception

class ListViewModel : ViewModel() {

    fun getListOfMoviesFromRemoteDb(): List<Movie> {

        viewModelScope.launch {
            try {
                val retrofitInstance = RetrofitInstance
                    .getRetrofitInstance()
                    .create(MovieService::class.java)

                val response: MyListResponse<Movie> = retrofitInstance.getAllMovies("00001428")
                val movies = response.data

                if (movies != null) {
                    for (movie in movies){
                        Log.d("Movie_item: ", movie.toString())
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


        return emptyList() //todo

    }

    fun deleteOneMovieById(){
        viewModelScope.launch {
            try {
                val retrofitInstance = RetrofitInstance
                    .getRetrofitInstance()
                    .create(MovieService::class.java)

                val response: MyItemResponse<Unit> = retrofitInstance.deleteOneMovieById(
                    "36",
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