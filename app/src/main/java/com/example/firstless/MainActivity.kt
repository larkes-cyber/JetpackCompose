package com.example.firstless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstless.ui.theme.FirstLessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxSize(0.8f)
                    .background(Color.Green)
                    .border(5.dp, Color.Cyan)
                    .padding(5.dp)
                    .border(5.dp, Color.DarkGray)
                    .padding(5.dp)
                    .border(20.dp, Color.Magenta)
                    .padding(20.dp)

            ) {

                Text(
                    text = "hello",
                    modifier = Modifier
                        .border(5.dp, Color.LightGray)
                        .padding(5.dp)
                        .offset(20.dp, 20.dp)
                        .border(5.dp, Color.Red)
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.2f))
                Text(
                    text = "hello",
                    modifier = Modifier
                        .border(5.dp, Color.LightGray)
                        .padding(5.dp)
                        .offset(20.dp, 20.dp)
                        .border(5.dp, Color.Red)
                        .padding(5.dp)
                )

            }
        }
    }
}

