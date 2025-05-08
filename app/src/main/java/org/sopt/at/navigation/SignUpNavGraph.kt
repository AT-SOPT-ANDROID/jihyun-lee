package org.sopt.at.navigation

import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.sopt.at.presentation.signup.IdInputScreen
import org.sopt.at.presentation.signup.PasswordInputScreen
import org.sopt.at.presentation.signup.SignUpViewModel

fun NavGraphBuilder.signupNavGraph(navController: NavHostController) {
    composable("IdInputScreen") { backStackEntry ->
        val parentEntry = remember (backStackEntry){
            navController.getBackStackEntry("IdInputScreen")
        }
        val viewModel: SignUpViewModel = viewModel(parentEntry)
        IdInputScreen(navController,viewModel)
    }
    composable("PasswordInputScreen"){ backStackEntry ->
        val parentEntry = remember(backStackEntry){
            navController.getBackStackEntry("IdInputScreen")
        }
        val viewModel: SignUpViewModel = viewModel(parentEntry)
        PasswordInputScreen(navController, viewModel)
    }
}