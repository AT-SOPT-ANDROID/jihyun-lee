package org.sopt.at.my

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.R

@Composable
fun MyView(modifier: Modifier = Modifier){
    Surface (
        modifier = modifier,
        color = Color.Black
    ) {
        Column (
            modifier = Modifier.padding(top=25.dp, start = 15.dp, end = 15.dp, bottom = 25.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id=R.drawable.back),
                    contentDescription = "뒤로가기 버튼",
                    modifier = Modifier.size(20.dp)
                )

                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        painter = painterResource(R.drawable.notice),
                        contentDescription = "알림",
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Image(
                        painter = painterResource(R.drawable.setting),
                        contentDescription = "설정",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.padding(20.dp)
            )

            Row (
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.my_tiving_icon),
                    contentDescription = "My Icon",
                    modifier = Modifier.size(80.dp)
                )

                Text(
                    text = "프로필",
                    color = Color.White
                )

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ){
                    OutlinedButton(
                        onClick = {},
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Transparent
                            )
                    ) {
                        Text(
                            text = "프로필 전환"
                        )

                        Text(
                            text = "사용중인 이용권이 없습니다"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Column {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "나의 이용권"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMyView(){
    MyView(Modifier.fillMaxSize())
}
