package org.sopt.at.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.sopt.at.my.MyScreen

fun NavGraphBuilder.myNavGraph(navController: NavHostController) {
    composable("MyScreen/{userId}") { backStackEntry ->
        val userId = backStackEntry.arguments?.getString("userId") ?: "프로필"
        MyScreen(navController, userId)
    }
}