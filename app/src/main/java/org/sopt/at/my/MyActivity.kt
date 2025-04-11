package org.sopt.at.my

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userId = intent.getStringExtra("userId") ?: "프로필"
        setContent {
            MyView(userId = userId)
        }
    }
}