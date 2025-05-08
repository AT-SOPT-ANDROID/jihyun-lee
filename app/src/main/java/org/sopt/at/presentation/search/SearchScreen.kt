package org.sopt.at.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import org.sopt.at.utils.BottomNavigation

@Composable
fun SearchScreen(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ){
        Text(
            text = "Search Screen"
        )
        BottomNavigation(navController = navController)
    }
}