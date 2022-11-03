package com.example.mynavigationsample.detailedView

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.MovieService
import com.example.mynavigationsample.network.RetrofitInstance
import com.example.mynavigationsample.network.myResponse.MyItemResponse
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

    fun getMovieByIdFromRemoteDb(movieId: String): Movie {
        viewModelScope.launch {
            try {
                val retrofitInstance = RetrofitInstance
                    .getRetrofitInstance()
                    .create(MovieService::class.java)

                val response: MyItemResponse<Movie> =
                    retrofitInstance.getOneMovieById(movieId, Constants.STUDENT_ID)
                val movieFromResponse = response.data

                if (movieFromResponse != null) {
                    movieLiveData.value = movieFromResponse
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
        )
    }

    fun editMovieById() {
//        viewModelScope.launch {
//            try {
//                val retrofitInstance = RetrofitInstance
//                    .getRetrofitInstance()
//                    .create(MovieService::class.java)
//
//                val response: MyItemResponse<Unit> = retrofitInstance.updateOneMovieById(
//                    "28",
//                    "00001428",
//                    //todo pass movie object to update)
//
//                    Log.d("Update_response", response.toString())
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
    }
}