package org.sopt.at.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.sopt.at.presentation.ui.MyScreen

fun NavGraphBuilder.myNavGraph(navController: NavHostController) {
    composable(Screen.My.route) { MyScreen(navController) }
}