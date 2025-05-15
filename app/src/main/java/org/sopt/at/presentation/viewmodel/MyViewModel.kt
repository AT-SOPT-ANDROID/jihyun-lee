package org.sopt.at.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.at.domain.repository.UserRepository
import javax.inject.Inject
import android.util.Log

@HiltViewModel
class MyViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _nickname = MutableStateFlow("프로필")
    val nickname: StateFlow<String> = _nickname

    private val _isLoggedOut = MutableStateFlow(false)
    val isLoggedOut: StateFlow<Boolean> = _isLoggedOut

    fun fetchUserNickname(userId: Long) {
        viewModelScope.launch {
            try {
                val response = userRepository.getUserNickname(userId)
                val body = response.body()
                if (body != null) {
                    if (body.success) {
                        _nickname.value = body.data.nickname
                    } else {
                        Log.e("MyProfileViewModel", "API 실패: ${response.code()}")
                    }
                }
            } catch (e: Exception) {
                Log.e("MyProfileViewModel", "예외 발생: ${e.localizedMessage}")
            }
        }
    }

    fun logout(context: Context) {
        viewModelScope.launch {
            val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                clear()
                apply()
            }
            _isLoggedOut.value = true
        }
    }

    fun clearLogoutState() {
        _isLoggedOut.value = false
    }

}