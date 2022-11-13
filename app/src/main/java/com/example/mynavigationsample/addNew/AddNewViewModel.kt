package com.example.madseminarthreesolution.addNew

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynavigationsample.MainActivity
import com.example.mynavigationsample.addNew.AddNewActivity
import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.MovieService
import com.example.mynavigationsample.network.RetrofitInstance
import com.example.mynavigationsample.network.movie.MovieRequest
import com.example.mynavigationsample.network.myResponse.MyItemResponse
import com.example.mynavigationsample.network.myResponse.MyResponse
import com.example.mynavigationsample.utils.Constants
import kotlinx.coroutines.launch

class AddNewViewModel : ViewModel() {

    val movieInsertResponse: MutableLiveData<MyResponse> by lazy {
        MutableLiveData<MyResponse>()
    }

    fun saveNewMovieToRemoteDb(movie: MovieRequest) {

        viewModelScope.launch {
            try {

                val response: MyResponse = RetrofitInstance.movieService.insertNewMovie(
                    Constants.STUDENT_ID,
                    movie
                )

                movieInsertResponse.value = response

                Log.d("Update_response", response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}