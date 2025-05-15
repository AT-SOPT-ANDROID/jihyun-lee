package org.sopt.at.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.sopt.at.R
import org.sopt.at.presentation.navigation.Screen

@Composable
fun BottomNavigation(navController:NavController){
    val iconSize = 40.dp
    val iconPadding = 5.dp
    val padding = 10.dp

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(padding)
                    .clickable {
                    navController.navigate(Screen.Home.route)
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.bottom_navicon_home),
                    contentDescription = "HomeView",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(iconPadding)
                )
                Text(
                    text = stringResource(R.string.bottom_nav_home),
                    color = Color.White
                )
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(padding)
                    .clickable {
                    navController.navigate(Screen.Shorts.route)
                }
            ) {

                Image(
                    painter = painterResource(R.drawable.bottom_navicon_shorts),
                    contentDescription = "ShortsView",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(iconPadding)
                )
                Text(
                    text = stringResource(R.string.bottom_nav_shorts),
                    color = Color.White
                )
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(padding)
                    .clickable {
                    navController.navigate(Screen.Live.route)
                }
            ) {

                Image(
                    painter = painterResource(R.drawable.bottom_navicon_live),
                    contentDescription = "ShortsView",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(iconPadding),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(
                    text = stringResource(R.string.bottom_nav_live),
                    color = Color.White
                )
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(padding)
                    .clickable {
                    navController.navigate(Screen.Search.route)
                }
            ) {

                Image(
                    painter = painterResource(R.drawable.bottom_navicon_search),
                    contentDescription = "SearchView",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(iconPadding),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(
                    text = stringResource(R.string.bottom_nav_search),
                    color = Color.White
                )
            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(padding)
                    .clickable {
                    navController.navigate(Screen.History.route)
                }
            ) {

                Image(
                    painter = painterResource(R.drawable.bottom_navicon_history),
                    contentDescription = "HistoryView",
                    modifier = Modifier
                        .size(iconSize)
                        .padding(iconPadding),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Text(
                    text = stringResource(R.string.bottom_nav_history),
                    color = Color.White
                )
            }

        }
    }


}
