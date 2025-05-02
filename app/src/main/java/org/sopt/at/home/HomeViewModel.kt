package org.sopt.at.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.sopt.at.R

class HomeViewModel: ViewModel() {
    val tabItems = mutableListOf("DRAMA", "VARIETY", "MOVIE", "SPORTS", "ANIMATION")
    var selectedTabIndex = mutableStateOf(0)

    fun selectTab(index:Int){
        selectedTabIndex.value = index
    }

    val dramaItems = mutableListOf(
        R.drawable.drama1_poster_image,
        R.drawable.drama2_poster_image,
        R.drawable.drama3_poster_image,
        R.drawable.drama4_poster_image,
        R.drawable.drama5_poster_image,
        R.drawable.drama6_poster_image,
        R.drawable.drama7_poster_image,
        R.drawable.drama8_poster_image,
        R.drawable.drama9_poster_image,
        R.drawable.drama10_poster_image
    )
}