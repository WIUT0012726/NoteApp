package com.example.madseminarthreesolution.addNew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynavigationsample.addNew.AddNewView
import com.example.mynavigationsample.ui.theme.MyNavigationSampleTheme

class AddNewActivity : ComponentActivity() {

    private lateinit var viewModel: AddNewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = AddNewViewModel()

        setContent {
            MyNavigationSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AddNewView()
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview3() {
        MyNavigationSampleTheme {
            AddNewView()
        }
    }
}