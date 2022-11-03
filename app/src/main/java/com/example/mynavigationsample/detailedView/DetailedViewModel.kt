package com.example.mynavigationsample.detailedView

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.MovieService
import com.example.mynavigationsample.network.MyItemResponse
import com.example.mynavigationsample.network.MyResponse
import com.example.mynavigationsample.network.RetrofitInstance
import kotlinx.coroutines.launch

class DetailedViewModel : ViewModel() {
    fun getMovieByIdFromRemoteDb(movieId: String): Movie {
        viewModelScope.launch {
            try {
                val retrofitInstance = RetrofitInstance
                    .getRetrofitInstance()
                    .create(MovieService::class.java)
                val response: MyItemResponse<Movie> =
                    retrofitInstance.getOneMovieById(movieId,"00001428")
                val movie = response.data
                if (movie != null) {
                        Log.d("One_movie_item: ", movie.toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return Movie(
            "1",
            "Mad Max",
            "Guys killing each other in Australia",
            listOf("Tom Hardy", "Charliz Theron"),
            "350"
        ) //todo remove dummy data
    }
}