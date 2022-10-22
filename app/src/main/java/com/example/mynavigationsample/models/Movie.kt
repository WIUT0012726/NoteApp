package com.example.mynavigationsample.models

data class Movie(
    val id: String,
    val name: String,
    val description: String,
    val actors: List<String>,
    val budget: String
)