package org.sopt.at.presentation.signup

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

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
    IdInputScreen(navController)
}

@Preview(showBackground = true)
@Composable
fun showPwInput(){
    val navController = rememberNavController()
    PasswordInputScreen(navController, "userId")
}