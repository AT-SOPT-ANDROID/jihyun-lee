package org.sopt.at.presentation.navigation

sealed class Screen(val route: String) {
    // SignUp
    object IdInput: Screen("id_input")
    object PasswordInput: Screen("password_input")
    object NicknameInput: Screen("nickname_input")

    // SignIn
    object SignIn: Screen("sign_in")

    // Home
    object Home: Screen("home")
    object Shorts: Screen("shorts")
    object Live: Screen("live")
    object Search: Screen("search")
    object History: Screen("history")

    // MyPage
    object My: Screen("my")
}