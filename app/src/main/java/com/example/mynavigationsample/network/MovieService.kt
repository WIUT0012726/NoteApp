package com.example.mynavigationsample.network

import com.example.mynavigationsample.models.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("records/all")
    suspend fun getAllMovies(@Query("student_id") student_id: String):
            MyResponse<Movie>
}