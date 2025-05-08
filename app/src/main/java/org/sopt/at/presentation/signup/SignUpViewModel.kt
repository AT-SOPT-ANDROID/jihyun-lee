package org.sopt.at.presentation.signup

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    private val _userId = MutableStateFlow("")
    val userId: StateFlow<String> = _userId

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun onUserIdChange(newId: String) {
        _userId.value = newId
    }

    fun onPasswordChange(newPw: String) {
        _password.value = newPw
    }

    fun signUp(context: Context, onSuccess: () -> Unit) {
        viewModelScope.launch {
            val prefs = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            with(prefs.edit()) {
                putString("userId", _userId.value)
                putString("password", _password.value)
                apply()
            }
            Toast.makeText(context, "회원가입 성공!", Toast.LENGTH_SHORT).show()
            onSuccess()
        }
    }
}