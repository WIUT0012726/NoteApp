package com.example.mynavigationsample.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val name: String,
    @SerializedName("description")
    val description: String,
    val actors: List<String>?,
    val budget: String
)