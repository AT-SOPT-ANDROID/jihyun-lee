package org.sopt.at.presentation.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.R

@Composable
fun CustomButton(
    text: String,
    onClick: ()->Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Transparent,
    textColor: Color = Color.Black,
    showBorder: Boolean = true,
    shape: Shape = TextFieldDefaults.shape
){
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(50.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor
        ),
        shape = shape,
        border = ButtonDefaults.outlinedButtonBorder(enabled = showBorder),
        interactionSource = remember { MutableInteractionSource() },
    ){
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
fun ShowSignInButton(){
    CustomButton(
        text = "로그인하기",
        onClick = {},
        containerColor = colorResource(R.color.login_button),
        showBorder = false,
        textColor = colorResource(R.color.login_button_text)
    )
}

@Composable
@Preview
fun ShowNextButton(){
    CustomButton(
        text = "다음",
        onClick = {},
        textColor = colorResource(R.color.login_menu_text)
    )
}