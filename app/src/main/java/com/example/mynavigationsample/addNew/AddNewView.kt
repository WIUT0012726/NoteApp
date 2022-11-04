package com.example.mynavigationsample.addNew

import android.view.Gravity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.madseminarthreesolution.addNew.AddNewViewModel
import com.example.mynavigationsample.R
import com.example.mynavigationsample.network.movie.MovieRequest
import com.example.mynavigationsample.utils.parseActorsFromInput


@Composable
fun AddNewView(viewModel: AddNewViewModel = AddNewViewModel()) {
    val context = LocalContext.current

    val name = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val actors = remember { mutableStateOf("") }
    val budget = remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        NameInput(name = name.value, onNameChange = { name.value = it })
        Spacer(Modifier.height(16.dp))
        DescriptionInput(
            description = description.value,
            onDescriptionChange = { description.value = it })
        Spacer(Modifier.height(16.dp))
        ActorsInput(actors = actors.value, onActorsChange = { actors.value = it })
        Spacer(Modifier.height(16.dp))
        BudgetInput(budget = budget.value, onBudgetChange = { budget.value = it })
        Spacer(Modifier.height(16.dp))

        val validationMsg = stringResource(id = R.string.add_new_validation_msg)
        AddNewButton {
            if (isInputValid(name.value, description.value, actors.value, budget.value)) {
                viewModel.saveNewMovieToRemoteDb(
                    MovieRequest(
                        name.value,
                        description.value,
                        parseActorsFromInput(actors.value),
                        budget.value
                    )
                )

                //todo show network response result to the user
            } else {
                val toast = Toast.makeText(context, validationMsg, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
        }
    }
}


@Composable
private fun NameInput(name: String, onNameChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = name,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onNameChange(it) },
        label = {
            Text(stringResource(id = R.string.add_new_name_input_hint))
        }
    )
}


@Composable
private fun DescriptionInput(description: String, onDescriptionChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.LightGray),
        value = description,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onDescriptionChange(it) },
        label = {
            Text(stringResource(id = R.string.add_new_description_input_hint))
        }
    )
}

@Composable
private fun ActorsInput(actors: String, onActorsChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.LightGray),
        value = actors,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onActorsChange(it) },
        label = {
            Text(stringResource(id = R.string.add_new_actors_input_hint))
        }
    )
}

@Composable
private fun BudgetInput(budget: String, onBudgetChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = budget,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { onBudgetChange(it) },
        label = {
            Text(stringResource(id = R.string.add_new_name_budget_hint))
        }
    )
}

@Composable
private fun AddNewButton(onClick: () -> Unit) {

    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.add_new_save_button_text)
        )
    }
}

private fun isInputValid(
    name: String,
    description: String,
    actors: String,
    budget: String
): Boolean {
    if (name.isBlank() || description.isBlank() || actors.isBlank()) return false

    if (budget.isBlank() || !budget.isDigitsOnly()) return false

    return true
}
