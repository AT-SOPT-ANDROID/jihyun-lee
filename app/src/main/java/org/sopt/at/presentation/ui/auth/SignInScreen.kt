package org.sopt.at.presentation.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.sopt.at.R
import org.sopt.at.presentation.component.CustomButton
import org.sopt.at.presentation.component.SignInTextField
import org.sopt.at.presentation.navigation.Screen
import org.sopt.at.presentation.viewmodel.SignInViewModel

@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }

    var passwordVisible by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val userId by viewModel.loginId.collectAsState()
    val password by viewModel.password.collectAsState()
    val loginSuccess by viewModel.loginSuccess.collectAsState()
    val loginError by viewModel.loginError.collectAsState()

    LaunchedEffect(loginSuccess) {
        if (loginSuccess) {
            navController.navigate(Screen.My.route) {
                popUpTo("SignInScreen") { inclusive = true }
            }
        }
    }
    LaunchedEffect(loginSuccess) {
        if(loginSuccess){
            snackbarHostState.showSnackbar("로그인 성공")
            navController.navigate(Screen.My.route)
            viewModel.clearLoginResult()
        }
    }
    // 로그인 실패 시 Snackbar 표시
    LaunchedEffect(loginError) {
        if (loginError) {
            snackbarHostState.showSnackbar("로그인 실패! 아이디와 비밀번호를 확인해주세요.")
            viewModel.clearLoginResult()
        }
    }


    Surface (
        color = Color.Black,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column (
            modifier = Modifier.padding(top=25.dp, start = 15.dp, end = 15.dp, bottom = 25.dp)
        ) {
            Image(
                painter = painterResource(id=R.drawable.back),
                contentDescription = "뒤로가기 버튼",
                modifier = Modifier.size(20.dp)
            )

            Spacer(
                modifier = Modifier.padding(20.dp)
            )

            Text(
                text = stringResource(R.string.login_title),
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SignInTextField(
                    value = userId,
                    onValueChange = { viewModel.onUserIdChange(it) },
                    placeholderText = "아이디"
                )
                Spacer(modifier = Modifier.padding(10.dp))
                SignInTextField(
                    value = password,
                    onValueChange = { viewModel.onPasswordChange(it) },
                    placeholderText = "비밀번호",
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(id = if (passwordVisible) R.drawable.login_show else R.drawable.login_hide),
                                contentDescription = "비밀번호 보기",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.padding(15.dp))

                CustomButton(
                    text = "로그인하기",
                    onClick = {
                        viewModel.login(context)
                    },
                    containerColor = colorResource(R.color.login_button),
                    showBorder = false,
                    textColor = colorResource(R.color.login_button_text)
                )

                Spacer(modifier = Modifier.padding(20.dp))

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val verticalDividerModifier = Modifier
                        .padding(horizontal = 20.dp)
                        .height(15.dp)
                    val textSize = 14.sp
                    val textColor = R.color.login_menu_text
                    val dividerColor = R.color.login_divider
                    Text(
                        text="아이디 찾기",
                        color = colorResource(textColor),
                        fontSize = textSize
                    )
                    VerticalDivider(
                        modifier = verticalDividerModifier,
                        color = colorResource(dividerColor),
                        thickness = 1.dp
                    )
                    Text(
                        text="비밀번호 찾기",
                        color = colorResource(textColor),
                        fontSize = textSize
                    )
                    VerticalDivider(
                        modifier = verticalDividerModifier,
                        color = colorResource(dividerColor),
                        thickness = 1.dp
                    )
                    Text(
                        text="회원가입",
                        color = colorResource(textColor),
                        fontSize = textSize,
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.IdInput.route)
                        }
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "이 사이트는 Google reCAPTCHA로 보호되며,\n" +
                            "Google 개인정보 처리방침과 서비스 약관이 적용됩니다.",
                    color = colorResource(R.color.login_text),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp
                )
            }
        }
    }
}