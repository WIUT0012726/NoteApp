package com.example.mynavigationsample.network

import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.movie.MovieRequest
import com.example.mynavigationsample.network.movie.MovieResponse
import com.example.mynavigationsample.network.myResponse.MyItemResponse
import com.example.mynavigationsample.network.myResponse.MyListResponse
import com.example.mynavigationsample.network.myResponse.MyResponse
import retrofit2.http.*

interface MovieService {
    @GET("records/all")
    suspend fun getAllMovies(
        @Query("student_id") student_id: String
    ): MyListResponse<MovieResponse>

    @GET("records/{record_id}")
    suspend fun getOneMovieById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String
    ): MyItemResponse<MovieResponse>

    @POST("records")
    suspend fun insertNewMovie(
        @Query("student_id") student_id: String,
        @Body movieRequest: MovieRequest
    ): MyResponse

    @PUT("records/{record_id}")
    suspend fun updateOneMovieById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String,
        movieRequest: MovieRequest
    ): MyResponse

    @DELETE("records/{record_id}")
    suspend fun deleteOneMovieById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String
    ): MyResponse

    @DELETE("records/all")
    suspend fun deleteAllMovies(
        @Query("student_id") student_id: String
    ): MyResponse
}