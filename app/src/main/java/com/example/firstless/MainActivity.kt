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

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painter = painterResource(id = R.drawable.image)
            val description = "dsgsdf"
            val title = "lolka"

            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
                ) {
                ImageCard(painter,title,description)
            }

        }
    }
}

@Composable
fun ImageCard(
    painter:Painter,
    title: String,
    description:String,
    modifier:Modifier = Modifier
){
     val startColor = Color(31,23,39)
     val endColor = Color(0,0,0,0)
    Card(
        modifier = modifier
            .height(129.dp)
            .fillMaxWidth(0.9f),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {

        Box(
            modifier = Modifier
                .height(129.dp)
        ){

            Image(
                painter = painter,
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                    colors = listOf(
                        endColor,
                        startColor
                    ),
                    startY = 0f,
                    endY = 210f
                ))
        ) {

        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
            contentAlignment = Alignment.BottomStart
        ){
            Text(
                text = title,
                style = TextStyle(color = Color.White,fontSize = 16.sp)
            )
        }

    }
}

