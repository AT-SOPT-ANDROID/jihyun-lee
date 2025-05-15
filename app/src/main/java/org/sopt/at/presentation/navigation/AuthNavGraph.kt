package org.sopt.at.presentation.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.sopt.at.presentation.ui.auth.SignInScreen
import org.sopt.at.presentation.ui.auth.IdInputScreen
import org.sopt.at.presentation.ui.auth.NicknameInputScreen
import org.sopt.at.presentation.ui.auth.PasswordInputScreen
import org.sopt.at.presentation.viewmodel.SignUpViewModel

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    // SignIn
    composable(Screen.SignIn.route) { SignInScreen(navController) }

    // SignUp
    composable(Screen.IdInput.route) { backStackEntry ->
        val parentEntry = remember (backStackEntry){
            navController.getBackStackEntry(Screen.IdInput.route)
        }
        val viewModel: SignUpViewModel = hiltViewModel(parentEntry)
        IdInputScreen(navController,viewModel)
    }
    composable(Screen.PasswordInput.route){ backStackEntry ->
        val parentEntry = remember(backStackEntry){
            navController.getBackStackEntry(Screen.IdInput.route)
        }
        val viewModel: SignUpViewModel = hiltViewModel(parentEntry)
        PasswordInputScreen(navController, viewModel)
    }
    composable(Screen.NicknameInput.route) { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(Screen.IdInput.route)
        }
        val viewModel: SignUpViewModel = hiltViewModel(parentEntry)
        NicknameInputScreen(navController, viewModel)
    }
}