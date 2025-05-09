package org.sopt.at.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.at.data.model.RequestSignInDto
import org.sopt.at.domain.repository.SignInRepository
import org.sopt.at.domain.repository.SignUpRepository
import org.sopt.at.presentation.signin.getUserInfo
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInRepository: SignInRepository
): ViewModel() {
    private val _loginId = MutableStateFlow("")
    val loginId: StateFlow<String> = _loginId

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _loginError = MutableStateFlow(false)
    val loginError: StateFlow<Boolean> = _loginError

    fun onUserIdChange(newId: String) {
        _loginId.value = newId
    }

    fun onPasswordChange(newPw: String) {
        _password.value = newPw
    }

    fun login(context: Context) {
        viewModelScope.launch {
            try {
                val request = RequestSignInDto(
                    loginId = _loginId.value,
                    password = _password.value
                )
                val response = signInRepository.signIn(request)

                if (response.isSuccessful) {
                    val body = response.body()
                    if (body?.success == true) {
                        // 성공: 로그인 성공 처리
                        val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                        with(sharedPref.edit()) {
                            putString("userId", _loginId.value)
                            apply()
                        }
                        _loginSuccess.value = true
                        Toast.makeText(context, "로그인 성공!", Toast.LENGTH_SHORT).show()
                    } else {
                        _loginError.value = true
                        Toast.makeText(context, body?.message ?: "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    _loginError.value = true
                    Toast.makeText(context, "서버 오류: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                _loginError.value = true
                Toast.makeText(context, "에러: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun clearLoginResult() {
        _loginSuccess.value = false
        _loginError.value = false
    }
}