package org.sopt.at.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.R

@Composable
fun IdInputView(modifier:Modifier=Modifier){
    Surface (
        color = Color.Black,
        modifier = modifier.fillMaxSize()
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
                text = stringResource(R.string.signup_id),
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(20.dp))

            TextField(
                value = "",
                onValueChange = {},
                placeholder = {Text("아이디", color = colorResource(R.color.login_textField_text))},
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = colorResource(R.color.login_textField_background),
                    unfocusedIndicatorColor = Color.Transparent
                )
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
                    onClick = {},
                    modifier = modifier.fillMaxWidth().height(50.dp),
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
        }
    }
}

@Composable
fun PasswordInputView(modifier:Modifier=Modifier){
    Surface (
        color = Color.Black,
        modifier = modifier.fillMaxSize()
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
                text = stringResource(R.string.signup_passowrd),
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(20.dp))

            TextField(
                value = "",
                onValueChange = {},
                placeholder = {Text("비밀번호", color = colorResource(R.color.login_textField_text))},
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = colorResource(R.color.login_textField_background),
                    unfocusedIndicatorColor = Color.Transparent
                )
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
                    onClick = {},
                    modifier = modifier.fillMaxWidth().height(50.dp),
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showIdInputView(){
    IdInputView()
}

@Preview(showBackground = true)
@Composable
fun showPasswordInputView(){
    PasswordInputView()
}