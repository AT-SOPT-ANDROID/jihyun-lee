package org.sopt.at.signin

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme
import org.sopt.at.R
import org.sopt.at.my.MyActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInView() {
    // SnackbarHostState를 LogInView 내에서 remember로 관리
    val snackbarHostState = remember { SnackbarHostState() }

    var passwordVisible by remember { mutableStateOf(false) }
    var loginError by remember { mutableStateOf(false) } // 로그인 실패 여부 상태 관리

    var userId = ""
    var password = ""

    val context = LocalContext.current

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
                val textFieldModifier = Modifier.fillMaxWidth()
                val textFiledColors = TextFieldDefaults.colors(
                    unfocusedContainerColor = colorResource(R.color.login_textField_background),
                    unfocusedIndicatorColor = Color.Transparent
                )
                TextField(
                    value = "",
                    onValueChange = {
                        userId = it
                    },
                    placeholder = {Text("아이디", color = colorResource(R.color.login_textField_text))},
                    modifier = textFieldModifier,
                    colors = textFiledColors,
                )
                Spacer(modifier = Modifier.padding(10.dp))
                TextField(
                    value = "",
                    onValueChange = {
                        password = it
                    },
                    placeholder = { Text("비밀번호", color = colorResource(R.color.login_textField_text)) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = colorResource(R.color.login_textField_background),
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(id = if (passwordVisible) R.drawable.login_show else R.drawable.login_hide),
                                contentDescription = "비밀번호 보기",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.padding(15.dp))

                Button(
                    onClick = {
                        // 로그인 처리
                        if (userId == "user123" && password == "password123") {
                            // 로그인 성공 시 Toast 메시지
                            Toast.makeText(context, "로그인 성공!", Toast.LENGTH_SHORT).show()

                            // MyActivity로 이동
                            val intent = Intent(context, MyActivity::class.java)
                            context.startActivity(intent)
                        } else {
                            // 로그인 실패 시 Toast 메시지
                            Toast.makeText(context, "아이디 또는 비밀번호가 잘못되었습니다.", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.login_button)
                    ),
                    shape = TextFieldDefaults.shape
                ) {
                    Text(
                        text = "로그인하기",
                        color = colorResource(R.color.login_button_text),
                        fontWeight = FontWeight.Bold
                    )
                }

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
                        fontSize = textSize
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
    // 로그인 실패 시 Snackbar 표시
    LaunchedEffect(key1 = loginError) {
        if (loginError) {
            snackbarHostState.showSnackbar("로그인 실패! 아이디와 비밀번호를 확인해주세요.")
            loginError = false // Snackbar 표시 후 상태 초기화
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showLogInView(){
    LogInView()
}