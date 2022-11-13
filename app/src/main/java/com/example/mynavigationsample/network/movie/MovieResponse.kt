package com.example.mynavigationsample.network.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("text_list")
    val actors: List<MovieResponseActorItem>,
    @SerializedName("color") //I keep my budget value inside a "color" field in the database because of the test API limitations
    val budget: String
)