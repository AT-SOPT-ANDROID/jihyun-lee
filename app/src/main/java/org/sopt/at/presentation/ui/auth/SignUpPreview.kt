package org.sopt.at.presentation.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun ShowIdInput(){
    val navController = rememberNavController()
    IdInputScreen(navController, viewModel())
}

@Preview(showBackground = true)
@Composable
fun ShowPwInput(){
    val navController = rememberNavController()
    PasswordInputScreen(navController, viewModel())
}

@Preview(showBackground = true)
@Composable
fun ShowNnInput(){
    val navController = rememberNavController()
    NicknameInputScreen(navController, viewModel())
}