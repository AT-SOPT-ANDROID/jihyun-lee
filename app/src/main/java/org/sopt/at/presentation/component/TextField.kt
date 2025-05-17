package org.sopt.at.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.at.R

@Composable
fun SignInTextField (
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String = "",
    trailingIcon: @Composable (()->Unit)? = null
){
    val textFieldModifier = Modifier.fillMaxWidth()
    val textFiledColors = TextFieldDefaults.colors(
        unfocusedContainerColor = colorResource(R.color.login_textField_background),
        unfocusedIndicatorColor = Color.Transparent,
        focusedContainerColor = colorResource(R.color.login_textField_background),
        focusedIndicatorColor = colorResource(R.color.login_menu_text),
        focusedTextColor = colorResource(R.color.login_menu_text),
        unfocusedTextColor = colorResource(R.color.login_menu_text)
    )
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholderText, color = colorResource(R.color.login_textField_text)) },
        modifier = textFieldModifier,
        colors = textFiledColors,
        singleLine = true,
        trailingIcon = trailingIcon
    )
}

@Composable
@Preview
fun ShowSingInTextField(){
    SignInTextField(
        value = "userId",
        onValueChange = {},
        placeholderText = "아이디"
    )
}