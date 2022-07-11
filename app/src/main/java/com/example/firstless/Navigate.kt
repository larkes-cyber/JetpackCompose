package com.example.firstless

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import java.lang.reflect.Type

@Composable
fun Navigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "philip"
                    nullable = true
                }
            )
        ){
            DetailScreen(name = it.arguments?.getString("name"))
        }
    }
}


@Composable
fun MainScreen(navController: NavController){

    var text = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(80.dp))
        Button(
            onClick = {navController.navigate(Screen.DetailScreen.withArg(text.value))},
            modifier = Modifier.align(Alignment.End)){

            Text("Continue")
            
        }
    }
}

@Composable
fun DetailScreen(name:String?){

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
        ) {
        Text(text = name!!)
    }

}
