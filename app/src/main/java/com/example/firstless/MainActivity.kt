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
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import kotlin.random.Random

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Column(modifier = Modifier.fillMaxSize()) {

                val state = remember {
                    mutableStateOf(Color.Yellow)
                }
                ChangeBackground(
                    modifier = Modifier
                        .weight(1f)
                        .background(state.value)
                        .fillMaxSize()
                ){
                    state.value = it
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .background(state.value)
                        .fillMaxSize()
                ) {

                }

            }

        }
    }

    @Composable
    fun ChangeBackground(
        modifier: Modifier = Modifier,
        changeState: (Color) -> Unit
    ){



        Box(
            modifier = modifier
                .clickable {
                    changeState(Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    ))
                }
        ){

        }
    }


}


