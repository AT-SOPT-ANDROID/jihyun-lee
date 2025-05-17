package org.sopt.at.presentation.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.navigation.NavController
import org.sopt.at.R
import org.sopt.at.presentation.component.CustomButton
import org.sopt.at.presentation.component.SignInTextField
import org.sopt.at.presentation.navigation.Screen
import org.sopt.at.presentation.viewmodel.SignUpViewModel

@Composable
fun NicknameInputScreen(
    navController: NavController,
    viewModel: SignUpViewModel
){
    val nickname by viewModel.nickname.collectAsState()
    val context = LocalContext.current

    Surface (
        color = Color.Black,
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.padding(top=25.dp, start = 15.dp, end = 15.dp, bottom = 25.dp)
        ) {
            Image(
                painter = painterResource(id= R.drawable.back),
                contentDescription = "뒤로가기 버튼",
                modifier = Modifier.size(20.dp)
            )

            Spacer(
                modifier = Modifier.padding(20.dp)
            )

            Text(
                text = stringResource(R.string.signup_nickname),
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(20.dp))

            SignInTextField(
                value = nickname,
                onValueChange = { viewModel.onNicknameChange(it) },
                placeholderText = "닉네임"
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ){
                CustomButton(
                    text = "다음",
                    onClick = {
                        viewModel.signUp(context){
                            navController.navigate(Screen.SignIn.route)
                        }
                    },
                    textColor = colorResource(R.color.login_menu_text)
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
        }
    }
}