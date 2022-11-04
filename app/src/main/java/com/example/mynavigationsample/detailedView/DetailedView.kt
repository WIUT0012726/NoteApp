package com.example.mynavigationsample.detailedView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynavigationsample.R
import com.example.mynavigationsample.network.movie.MovieRequest

@Composable
fun DetailedView(movieId: String, viewModel: DetailedViewModel = DetailedViewModel(movieId)) {

    val movie by viewModel.movieLiveData.observeAsState()

    if (movie != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.movie_detailed_view_bg))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Name(name = movie!!.name)
                Spacer(Modifier.weight(1f))
                Budget(budget = movie!!.budget)
            }
            Description(description = movie!!.description)
            MyDivider()
            Spacer(Modifier.height(16.dp))
            if (!movie!!.actors.isNullOrEmpty()) {
                Actors(actors = movie!!.actors!!)
            }
//            EditButton {
//                viewModel.editMovieById(movieId, MovieRequest(
//                    movie!!.name,
//                    "test desc",
//                    movie!!.actors,
//                    movie!!.budget))
//            }
        }
    }
}

@Composable
private fun Name(name: String) {
    Text(
        text = name,
        color = Color.Black,
        fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Budget(budget: String) {
    Text(
        modifier = Modifier.padding(bottom = 3.dp),
        text = stringResource(id = R.string.detailed_view_budget_label, budget),
        color = Color.Black,
        fontSize = 15.sp,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
private fun Description(description: String) {
    Text(
        modifier = Modifier.padding(top = 10.dp),
        text = description,
        color = Color.DarkGray,
        fontSize = 22.sp,
        fontFamily = FontFamily.SansSerif
    )
}


@Composable
private fun Actors(actors: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        var i = 0
        for (actor in actors) {
            ActorTextView(actor = actor, ++i == actors.size)
        }
    }
}

@Composable
private fun ActorTextView(actor: String, isTheLastOne: Boolean) {
    Text(
        modifier = Modifier.padding(6.dp, 3.dp),
        text = if (isTheLastOne) actor else "$actor,",
        color = Color.DarkGray,
        fontSize = 19.sp,
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Italic
    )
}


@Composable
private fun MyDivider() {
    Divider(
        color = Color.LightGray
    )
}

//@Composable
//private fun EditButton(onClick: () -> Unit) {
//    Button(
//        onClick = {
//            onClick()
//        },
//        modifier = Modifier
//            .width(150.dp)
//            .height(75.dp)
//            .padding(vertical = 16.dp)
//    ) {
//        Text(
//            text = stringResource(id = R.string.edit_movie_button_text)
//        )
//    }
//}