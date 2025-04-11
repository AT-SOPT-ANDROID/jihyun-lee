package org.sopt.at.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*
import org.sopt.at.signin.SignInActivity

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "idInput"){
                composable("idInput") {IdInputView(navController)}
                composable("pwInput") {PasswordInputView(navController)}
            }
        }
    }

    public fun navigateToSignInActivity(){
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}