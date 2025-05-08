package org.sopt.at.presentation.my

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private val _userId = MutableStateFlow("프로필")
    val userId: StateFlow<String> = _userId

    private val _isLoggedOut = MutableStateFlow(false)
    val isLoggedOut: StateFlow<Boolean> = _isLoggedOut

    fun loadUserId(context: Context) {
        viewModelScope.launch {
            val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val savedId = sharedPref.getString("userId", "프로필") ?: "프로필"
            _userId.value = savedId
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