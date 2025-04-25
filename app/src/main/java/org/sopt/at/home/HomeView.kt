package org.sopt.at.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.sopt.at.R

@Composable
fun HomeView(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel(),
    dramaViewModel: DramaViewModel = viewModel()
){
    BottomNavigation(navController)

    val tabItems = homeViewModel.tabItems
    val selectedTabIndex = homeViewModel.selectedTabIndex.value

    val dramaItems = dramaViewModel.dramaItems

    val scrollState = rememberScrollState()

    Box(){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(bottom = 80.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.tving_text_logo),
                    contentDescription = "TVING",
                    modifier = Modifier.width(110.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Image(
                        painter = painterResource(R.drawable.icon_connect),
                        contentDescription = "Connect",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(25.dp)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Image(
                        painter = painterResource(R.drawable.my_tiving_icon),
                        contentDescription = "My Profile",
                        modifier = Modifier.size(25.dp)
                            .clickable { navController.navigate("MyView") }
                    )
                }
            }

            // 탭 항목들
            LazyRow (
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(10.dp)
            ) {
                items (tabItems.size) { index ->
                    TabItem(
                        title = tabItems[index],
                        isSelected = selectedTabIndex == index,
                        onclick = { homeViewModel.selectTab(index) }
                    )
                }
            }

            Column (
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {

                //  드라마 포스터
                LazyRow (
                    contentPadding = PaddingValues(15.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items (dramaItems) { poster ->
                        Image(
                            painter = painterResource(poster),
                            contentDescription = "Drama Poster",
                            modifier = Modifier
                                .width(340.dp)
                                .height(510.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }

                // 오늘의 티빙 top 20
                Text(
                    text = stringResource(R.string.today_tiving_top20),
                    color = Color.White,
                    modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                    fontSize = 18.sp
                )
                LazyRow (
                    contentPadding = PaddingValues(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    itemsIndexed (dramaItems) { index, poster ->
                        Row (
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = (index+1).toString(),
                                fontSize = 100.sp,
                                color = Color.White,
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier
                                    .fillMaxHeight()

                            )
                            Image(
                                painter = painterResource(poster),
                                contentDescription = "Drama Poster",
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(160.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                                contentScale = ContentScale.Fit
                            )
                        }

                    }
                }

                // 지금 방영 중인 콘텐츠
                Text(
                    text = stringResource(R.string.contents_on_air),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                )
                LazyRow (
                    contentPadding = PaddingValues(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    itemsIndexed (dramaItems) { index, poster ->
                        Image(
                            painter = painterResource(poster),
                            contentDescription = "Drama Poster",
                            modifier = Modifier
                                .width(120.dp)
                                .height(180.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        }

        BottomNavigation(navController)
    }

}

@Composable
fun TabItem(title:String, isSelected:Boolean, onclick:()->Unit){
    Text(
        text = title,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onclick },
        color = Color.White,
        fontSize = 18.sp
    )
}

@Preview(showBackground = true)
@Composable
fun ShowHomeView(){
    val navController = rememberNavController()
    HomeView(navController)
}