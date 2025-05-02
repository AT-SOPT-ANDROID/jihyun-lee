package org.sopt.at

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.sopt.at.history.HistoryScreen
import org.sopt.at.home.HomeScreen
import org.sopt.at.live.LiveScreen
import org.sopt.at.my.MyScreen
import org.sopt.at.search.SearchScreen
import org.sopt.at.shorts.ShortsScreen
import org.sopt.at.signup.IdInputScreen
import org.sopt.at.signup.PasswordInputScreen
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ATSOPTANDROIDTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val userId = intent.getStringExtra("userId")?:"프로필"

                    NavHost(navController=navController, startDestination="myView"){
                        composable("MyScreen/{userId}") { backStackEntry ->
                            val userId = backStackEntry.arguments?.getString("userId")
                            MyScreen(navController, userId)
                        }
                        composable("HomeScreen") { HomeScreen(navController) }
                        composable("ShortsScreen") { ShortsScreen(navController) }
                        composable("LiveScreen") { LiveScreen(navController) }
                        composable("SearchScreen") { SearchScreen(navController) }
                        composable("HistoryScreen") { HistoryScreen(navController) }
                        composable("IdInputScreen") {IdInputScreen(navController)}
                        composable("PasswordInputScreen"){ backStackEntry ->
                            val userId = backStackEntry.arguments?.getString("userId")
                            PasswordInputScreen(navController, userId.orEmpty())
                        }
                    }
                }
            }
        }
    }
}