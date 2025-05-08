package org.sopt.at.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.sopt.at.history.HistoryScreen
import org.sopt.at.home.HomeScreen
import org.sopt.at.live.LiveScreen
import org.sopt.at.search.SearchScreen
import org.sopt.at.shorts.ShortsScreen

fun NavGraphBuilder.homeNavGraph(navController: NavHostController) {
    composable("HomeScreen") { HomeScreen(navController) }
    composable("ShortsScreen") { ShortsScreen(navController) }
    composable("LiveScreen") { LiveScreen(navController) }
    composable("SearchScreen") { SearchScreen(navController) }
    composable("HistoryScreen") { HistoryScreen(navController) }
}