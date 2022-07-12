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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.firstless.ui.theme.FirstLessTheme
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            NavItem(
                                name = "Home",
                                route = "home",
                                icon = Icons.Default.Home
                            ),
                            NavItem(
                                name = "Chat",
                                route = "chat",
                                icon = Icons.Default.Notifications,
                                badgeCount = 200
                            ),
                            NavItem(
                                name = "Setting",
                                route = "setting",
                                icon = Icons.Default.Settings
                            )
                        ),
                        navHostController = navHostController,
                        onItemClick = { item ->
                            navHostController.navigate(item.route)
                        }
                    )
                }
            ) {
                Navigation(navHostController)
            }
        }
    }

    @Composable
    fun Navigation(navHostController: NavHostController){

        NavHost(navController = navHostController, startDestination = "home"){

            composable("home"){
                HomeScreen()
            }
            composable("chat"){
                ChatScreen()
            }
            composable("setting"){
                SettingScreen()
            }

        }

    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationBar(
    items:List<NavItem>,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick:(NavItem) -> Unit
){

    val backStackEntry = navHostController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {

        items.forEach {

            val selected = backStackEntry.value?.destination?.route == it.route

            BottomNavigationItem(
                selected = selected,
                onClick = {onItemClick(it)},
                icon = {
                       Column(horizontalAlignment = Alignment.CenterHorizontally) {

                           if(it.badgeCount > 0){
                               BadgeBox(
                                   badgeContent = {
                                       Text(text = it.badgeCount.toString())
                                   }
                               ) {
                                    Icon(
                                        imageVector = it.icon,
                                        contentDescription = it.name
                                    )
                               }
                           }else{
                               Icon(
                                   imageVector = it.icon,
                                   contentDescription = it.name
                               )
                           }
                           if(selected){
                               Text(
                                   text =  it.name,
                                   textAlign = TextAlign.Center,
                                   fontSize = 10.sp
                               )
                           }

                       }
                },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray
            )
        }

    }
}

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home screen")
    }
}

@Composable
fun ChatScreen(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Chat screen")
    }
}

@Composable
fun SettingScreen(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Setting screen")
    }
}
