package org.sopt.at.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val userId = intent.getStringExtra("userId")?:"프로필"

            NavHost(navController=navController, startDestination="myView"){
                composable("MyView") { MyView(navController, userId) }
                composable("HomeView") { HomeView(navController) }
                composable("ShortsView") { ShortsView(navController) }
                composable("LiveView") { LiveView(navController) }
                composable("SearchView") { SearchView(navController) }
                composable("HistoryView") { HistoryView(navController) }
            }
        }
    }
}