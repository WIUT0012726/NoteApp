package com.example.mynavigationsample.detailedView

import androidx.lifecycle.ViewModel
import com.example.mynavigationsample.models.Movie

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
//                //todo pass movie object to update)
//
//                Log.d("Update_response", response.toString())
//            } catch (e: Exception) {
//
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
}