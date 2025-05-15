package org.sopt.at.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
        authNavGraph(navController)
        homeNavGraph(navController)
        myNavGraph(navController)
    }
}