package com.example.mynavigationsample.network.movie

import com.google.gson.annotations.SerializedName

data class MovieRequest(
    @SerializedName("title")
    val name: String,
    @SerializedName("description")
    val description: String,
)