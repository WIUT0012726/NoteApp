package com.example.madseminarthreesolution.addNew

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

class AddNewViewModel : ViewModel() {

    //todo use livedata for response value

    fun saveNewMovieToRemoteDb(movie: MovieRequest) {

//todo

    }
}