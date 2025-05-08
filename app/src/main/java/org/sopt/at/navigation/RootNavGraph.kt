package org.sopt.at.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "start") {
        composable("start"){
            LaunchedEffect(Unit) {
                navController.navigate("MyScreen/프로필") {
                    popUpTo("start") { inclusive = true }
                }
            }
        }
        homeNavGraph(navController)
        signupNavGraph(navController)
        myNavGraph(navController)
    }
}