package org.sopt.at

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.at.navigation.RootNavGraph
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ATSOPTANDROIDTheme {
                val navController = rememberNavController()
                RootNavGraph(navController = navController)
            }
        }
    }
}