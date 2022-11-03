package com.example.mynavigationsample.network

import com.example.mynavigationsample.models.Movie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("records/all")
    suspend fun getAllMovies(@Query("student_id") student_id: String):
            MyListResponse<Movie>

    @GET("records/{record_id}")
    suspend fun getOneMovieById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String
    ): MyItemResponse<Movie>
}