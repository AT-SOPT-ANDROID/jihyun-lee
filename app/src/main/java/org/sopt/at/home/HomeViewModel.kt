package org.sopt.at.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.sopt.at.R

class HomeViewModel: ViewModel() {

    // 탭 목록은 고정 리스트
    val tabItems: List<String> = listOf("DRAMA", "VARIETY", "MOVIE", "SPORTS", "ANIMATION")

    // 선택된 탭 인덱스 - 상태 변경 감지를 위해 StateFlow 사용
    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex: StateFlow<Int> = _selectedTabIndex

    fun selectTab(index: Int) {
        _selectedTabIndex.value = index
    }

    // 포스터 이미지 목록도 불변 리스트로 정의
    val dramaItems: List<Int> = listOf(
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