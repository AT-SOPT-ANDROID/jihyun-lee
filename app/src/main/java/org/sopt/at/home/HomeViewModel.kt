package org.sopt.at.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    val tabItems = mutableListOf("DRAMA", "VARIETY", "MOVIE", "SPORTS", "ANIMATION")
    var selectedTabIndex = mutableStateOf(0)

    fun selectTab(index:Int){
        selectedTabIndex.value = index
    }
}