package com.example.firstless

import android.graphics.Paint
import android.icu.text.CaseMap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstless.ui.theme.FirstLessTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()
            val textFieldState = remember{
                mutableStateOf("")
            }
            val score = rememberCoroutineScope()

           Scaffold(
               modifier = Modifier.fillMaxSize(),
               scaffoldState = scaffoldState
           ) {

               Column(
                   modifier = Modifier
                       .fillMaxSize()
                       .padding(horizontal = 30.dp),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center
               ) {
                   TextField(
                       value = textFieldState.value,
                       label = {Text(text = "Enter your name")},
                       onValueChange = {
                           textFieldState.value = it
                       },
                       singleLine = true,
                       modifier = Modifier.height(60.dp)
                   )
                   Spacer(modifier = Modifier.height(16.dp))
                   Button(onClick = {
                       score.launch {
                           scaffoldState.snackbarHostState.showSnackbar("Hello ${textFieldState.value}")
                       }
                   }) {
                        Text(text = "Enter!")
                   }
               }

           }

        }
    }



}


