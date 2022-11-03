package com.example.mynavigationsample.network

import com.example.mynavigationsample.models.Movie
import com.example.mynavigationsample.network.movie.MovieRequest
import com.example.mynavigationsample.network.myResponse.MyItemResponse
import com.example.mynavigationsample.network.myResponse.MyListResponse
import retrofit2.http.*

interface MovieService {
    @GET("records/all")
    suspend fun getAllMovies(@Query("student_id") student_id: String): MyListResponse<Movie>

    @GET("records/{record_id}")
    suspend fun getOneMovieById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String
    ): MyItemResponse<Movie>

    @POST("records")
    suspend fun insertNewMovie(
        @Query("student_id") student_id: String,
        @Body movieRequest: MovieRequest
    ): MyItemResponse<Unit>

    @PUT("records/{record_id}")
    suspend fun updateOneMovieById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String,
        movie: Movie
    ): MyItemResponse<Unit>

    @DELETE("records/{record_id}")
    suspend fun deleteOneMovieById(
        @Path("record_id") record_id: String,
        @Query("student_id") student_id: String
    ): MyItemResponse<Unit>

    @DELETE("records/all")
    suspend fun deleteAllMovies(
        @Query("student_id") student_id: String
    ): MyItemResponse<Unit> //todo not tested yet
}