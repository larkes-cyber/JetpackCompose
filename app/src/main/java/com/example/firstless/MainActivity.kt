package com.example.firstless

import android.graphics.Paint
import android.icu.text.CaseMap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstless.ui.theme.FirstLessTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ){
                CircularAnimateBar(0.2f,100)
            }

        }
    }

    @Composable
    fun CircularAnimateBar(
        percentage:Float,
        number:Int,
        fontSize: TextUnit = 28.sp,
        radius:Dp = 50.dp,
        color:Color = Color.Green,
        strokeWidth:Dp = 8.dp,
        animDuration: Int = 1000,
        animDelay:Int = 0
        ){

        val animationPlayed = remember{
            mutableStateOf(false)
        }

        val curPercentage = animateFloatAsState(
            targetValue = if(animationPlayed.value) percentage else 0f,
            animationSpec = tween(
                durationMillis = animDuration,
                delayMillis = animDelay
            )
        )
        
        LaunchedEffect(key1 = true ){
            animationPlayed.value = true
        }

        Box(
            modifier = Modifier.size(radius * 2f),
            contentAlignment = Alignment.Center
        ){
            Canvas(modifier = Modifier.size(radius * 2f)){
                drawArc(
                    color,
                    -90f,
                    360*curPercentage.value,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(),cap = StrokeCap.Round)
                )
            }
        }

        Text(
            text = (curPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )

    }


}


