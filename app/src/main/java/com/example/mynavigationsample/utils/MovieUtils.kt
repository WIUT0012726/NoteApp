package com.example.mynavigationsample.utils

import com.example.mynavigationsample.network.movie.MovieResponseActorItem

fun extractListOfActorsFromResponse(
    actorsFromResponse: List<MovieResponseActorItem>
): List<String> {

    val myActors = mutableListOf<String>()

    for (actorObj in actorsFromResponse) {
        myActors.add(actorObj.actorName)
    }

    return myActors
}