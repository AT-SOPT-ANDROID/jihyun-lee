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
                navController.navigate("SignInScreen") {
                    popUpTo("start") { inclusive = true }
                }
            }
        }
        signinNavGraph(navController)
        homeNavGraph(navController)
        signupNavGraph(navController)
        myNavGraph(navController)
    }
}