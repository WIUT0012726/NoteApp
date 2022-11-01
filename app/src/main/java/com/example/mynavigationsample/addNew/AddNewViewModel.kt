package com.example.madseminarthreesolution.addNew

import androidx.lifecycle.ViewModel
import com.example.mynavigationsample.models.Movie

class AddNewViewModel : ViewModel() {

    fun saveNewMovieToRemoteDb(movie: Movie?) { //todo nullable for now

        //        viewModelScope.launch {
//            try {
//                val retrofitInstance = RetrofitInstance
//                    .getRetrofitInstance()
//                    .create(MovieService::class.java)
//
//                val response: MyItemResponse<Unit> = retrofitInstance.insertNewMovie(
//                    "00001428",
//                    MovieRequest("La la la", "La la bla bla, lalala")
//                )
//
//                    Log.d("Update_response", response.toString())
//            } catch (e: Exception) {
//
//            }
//        }

    }
}