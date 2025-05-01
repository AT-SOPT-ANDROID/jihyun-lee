package org.sopt.at.signin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.SnackbarHostState
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme

class SignInActivity : ComponentActivity() {

    private lateinit var snackbarHostState: SnackbarHostState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ATSOPTANDROIDTheme {
                LogInView()
            }
        }
    }
}
