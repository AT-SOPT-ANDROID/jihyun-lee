package org.sopt.at.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.sopt.at.presentation.my.MyScreen

fun NavGraphBuilder.myNavGraph(navController: NavHostController) {
    composable("MyScreen") { MyScreen(navController) }
}