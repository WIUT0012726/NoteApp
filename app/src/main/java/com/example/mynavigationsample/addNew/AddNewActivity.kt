package com.example.mynavigationsample.addNew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynavigationsample.ui.theme.MyNavigationSampleTheme

class AddNewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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