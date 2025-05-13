package org.sopt.at.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.sopt.at.data.model.RequestSignUpDto
import org.sopt.at.domain.repository.SignUpRepository
import javax.inject.Inject
import android.util.Log

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpRepository: SignUpRepository
) : ViewModel() {
    private val _userId = MutableStateFlow("")
    val userId: StateFlow<String> = _userId

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _nickname = MutableStateFlow("")
    val nickname: StateFlow<String> = _nickname

    fun onUserIdChange(newId: String) {
        _userId.value = newId
    }

    fun onPasswordChange(newPw: String) {
        _password.value = newPw
    }

    fun onNicknameChange(newNn: String){
        _nickname.value = newNn
    }

    fun signUp(context: Context, onSuccess: () -> Unit) {
        viewModelScope.launch {
            val request = RequestSignUpDto(
                loginId = _userId.value,
                password = _password.value,
                nickname = _nickname.value
            )

            try {
                val response = signUpRepository.signUp(request)
                val responseBody = response.body()

                Log.d("SignUpViewModel", "response.isSuccessful = ${response.isSuccessful}")
                Log.d("SignUpViewModel", "response.code = ${response.code()}")
                Log.d("SignUpViewModel", "response.body = ${response.body()}")

                if (responseBody != null) {
                    if ( responseBody.success){
                        Toast.makeText(context, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                        onSuccess()
                    } else {
                        Toast.makeText(context, "회원가입 실패: ${responseBody.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception){
                Log.e("SignUpViewModel", "회원가입 중 예외 발생: ${e.message}")
                Toast.makeText(context, "오류 발생: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}