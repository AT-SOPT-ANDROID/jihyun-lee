package org.sopt.at.signin

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SignInViewModel: ViewModel() {
    private val _userId = MutableStateFlow("")
    val userId: StateFlow<String> = _userId

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _loginError = MutableStateFlow(false)
    val loginError: StateFlow<Boolean> = _loginError

    fun onUserIdChange(newId: String) {
        _userId.value = newId
    }

    fun onPasswordChange(newPw: String) {
        _password.value = newPw
    }

    fun login(context: Context) {
        viewModelScope.launch {
            val (savedId, savedPw) = getUserInfo(context)
            if (_userId.value == savedId && _password.value == savedPw) {
                val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()){
                    putString("userId", _userId.value)
                    apply()
                }
                _loginSuccess.value = true
                Toast.makeText(context, "로그인 성공!", Toast.LENGTH_SHORT).show()
            } else {
                _loginError.value = true
                Toast.makeText(context, "아이디 또는 비밀번호가 잘못되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun clearLoginResult() {
        _loginSuccess.value = false
        _loginError.value = false
    }
}