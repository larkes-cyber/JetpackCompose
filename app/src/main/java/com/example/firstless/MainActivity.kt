package com.example.firstless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstless.ui.theme.FirstLessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(
                Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    Modifier
                        .background(Color.Green)
                        .fillMaxHeight(0.7f)
                        .fillMaxWidth(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "hello")
                    Text(text = "world")
                    Text(text = "hello")
                    Text(text = "world")
                }
                Row(
                    Modifier
                        .background(Color.Green)
                        .fillMaxHeight(0.7f)
                        .fillMaxWidth(0.5f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(text = "hello")
                    Text(text = "world")
                    Text(text = "hello")
                    Text(text = "world")
                }
            }



        }
    }
}

