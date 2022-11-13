package com.example.mynavigationsample.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val name: String,
    val description: String,
    val actors: List<String>,
    val budget: String
)