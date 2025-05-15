package org.sopt.at.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.sopt.at.presentation.ui.home.HistoryScreen
import org.sopt.at.presentation.ui.home.HomeScreen
import org.sopt.at.presentation.ui.home.LiveScreen
import org.sopt.at.presentation.ui.home.SearchScreen
import org.sopt.at.presentation.ui.home.ShortsScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    composable(Screen.Home.route) { HomeScreen(navController) }
    composable(Screen.Shorts.route) { ShortsScreen(navController) }
    composable(Screen.Live.route) { LiveScreen(navController) }
    composable(Screen.Search.route) { SearchScreen(navController) }
    composable(Screen.History.route) { HistoryScreen(navController) }
}