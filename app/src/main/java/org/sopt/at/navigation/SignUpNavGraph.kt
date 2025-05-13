package org.sopt.at.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.sopt.at.presentation.signup.IdInputScreen
import org.sopt.at.presentation.signup.NicknameInputScreen
import org.sopt.at.presentation.signup.PasswordInputScreen
import org.sopt.at.viewmodel.SignUpViewModel

fun NavGraphBuilder.signupNavGraph(navController: NavHostController) {
    composable("IdInputScreen") { backStackEntry ->
        val parentEntry = remember (backStackEntry){
            navController.getBackStackEntry("IdInputScreen")
        }
        val viewModel: SignUpViewModel = hiltViewModel(parentEntry)
        IdInputScreen(navController,viewModel)
    }
    composable("PasswordInputScreen"){ backStackEntry ->
        val parentEntry = remember(backStackEntry){
            navController.getBackStackEntry("IdInputScreen")
        }
        val viewModel: SignUpViewModel = hiltViewModel(parentEntry)
        PasswordInputScreen(navController, viewModel)
    }
    composable("NicknameInputScreen") { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry("IdInputScreen")
        }
        val viewModel: SignUpViewModel = hiltViewModel(parentEntry)
        NicknameInputScreen(navController, viewModel)
    }
}