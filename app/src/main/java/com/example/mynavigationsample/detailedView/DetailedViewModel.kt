package com.example.mynavigationsample.detailedView

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.MovieService
import com.example.mynavigationsample.network.RetrofitInstance
import com.example.mynavigationsample.network.myResponse.MyItemResponse
import kotlinx.coroutines.launch

class DetailedViewModel : ViewModel() {
    fun getMovieByIdFromRemoteDb(movieId: String): Movie {

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

        return Movie(
            "1",
            "Mad Max",
            "Guys killing each other in Australia",
            listOf("Tom Hardy", "Charliz Theron"),
            "350"
        )
    }

    fun editMovieById() {

    }
}