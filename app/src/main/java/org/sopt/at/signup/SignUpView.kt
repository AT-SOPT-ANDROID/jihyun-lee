package org.sopt.at.signup

import android.content.Context
import android.content.Intent
import android.widget.Toast
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.sopt.at.R
import org.sopt.at.my.MyActivity
import org.sopt.at.signin.SignInActivity


@Composable
fun IdInputView(navController: NavController){
    var userId by remember { mutableStateOf("") }

    Surface (
        color = Color.Black,
        modifier = Modifier.fillMaxSize()
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

            val textFiledColors = TextFieldDefaults.colors(
                unfocusedContainerColor = colorResource(R.color.login_textField_background),
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = colorResource(R.color.login_textField_background),
                focusedIndicatorColor = colorResource(R.color.login_menu_text),
                focusedTextColor = colorResource(R.color.login_menu_text),
                unfocusedTextColor = colorResource(R.color.login_menu_text)
            )

            OutlinedTextField(
                value = userId,
                onValueChange = { userId = it },
                placeholder = {Text("아이디", color = colorResource(R.color.login_textField_text))},
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
                        // userId를 인자로 pwInput 화면으로 전달
                        navController.navigate("pwInput/$userId")
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

@Composable
fun PasswordInputView(navController: NavController, userId: String){
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current

    Surface (
        color = Color.Black,
        modifier = Modifier.fillMaxSize()
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
                onValueChange = { password = it },
                placeholder = {Text("비밀번호", color = colorResource(R.color.login_textField_text))},
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
                        if (userId != null && password != null){
                            SignUp(context, userId, password)
                            val intent = Intent(context, SignInActivity::class.java)
                            intent.putExtra("userId", userId)
                            intent.putExtra("password", password)
                            context.startActivity(intent)
                        }
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

fun SignUp(context: Context, userId:String, password:String){
    val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    with(sharedPref.edit()) {
        putString("userId", userId)
        putString("password", password)
        apply()
    }

    // 회원가입 성공 후 Toast 메시지 띄우기
    Toast.makeText(context, "회원가입 성공!", Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun showIdInput(){
    val navController = rememberNavController()
    IdInputView(navController)
}

@Preview(showBackground = true)
@Composable
fun showPwInput(){
    val navController = rememberNavController()
    PasswordInputView(navController, "userId")
}