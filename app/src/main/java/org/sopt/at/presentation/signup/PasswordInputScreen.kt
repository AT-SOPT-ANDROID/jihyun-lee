package org.sopt.at.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import org.sopt.at.viewmodel.SignUpViewModel


@Composable
fun PasswordInputScreen(
    navController: NavController,
    viewModel: SignUpViewModel
){
    val password by viewModel.password.collectAsState()

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
                text = stringResource(R.string.signup_password),
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(20.dp))

            val textFiledColors = TextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(R.color.login_textField_background),
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = colorResource(R.color.login_textField_background),
                focusedIndicatorColor = colorResource(R.color.login_menu_text),
                focusedTextColor = colorResource(R.color.login_menu_text),
                unfocusedTextColor = colorResource(R.color.login_menu_text)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { viewModel.onPasswordChange(it) },
                placeholder = { Text("비밀번호", color = colorResource(R.color.login_textField_text)) },
                modifier = Modifier.fillMaxWidth(),
                colors = textFiledColors,
                singleLine = true
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "영문 소문자 또는 영문 소문자, 숫자 조합 6~12 자리",
                color = colorResource(R.color.login_text)
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ){
                OutlinedButton(
                    onClick = {
                        navController.navigate("NicknameInputScreen")
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.Transparent,
                        ),
                    shape = TextFieldDefaults.shape
                ) {
                    Text(
                        text = "다음",
                        color = colorResource(R.color.login_menu_text),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.padding(20.dp))
        }
    }
}