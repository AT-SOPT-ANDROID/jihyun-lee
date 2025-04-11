package org.sopt.at.my

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.R
import org.sopt.at.signin.SignInActivity

@Composable
fun MyView(userId: String = "프로필"){
    val scrollState = rememberScrollState()
    Surface (
        modifier = Modifier.verticalScroll(scrollState),
        color = Color.Black,
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
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.my_tiving_icon),
                    contentDescription = "My Icon",
                    modifier = Modifier.size(80.dp)
                )

                Text(
                    text = userId,
                    color = Color.White
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd,
                ){
                    OutlinedButton(
                        onClick = {},
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Transparent
                            )
                    ) {
                        Text(
                            text = "프로필 전환",
                            color = colorResource(R.color.my_text)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(20.dp))

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(R.color.my_menu_background))
                    .padding(20.dp)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "나의 이용권",
                        color = colorResource(R.color.my_text),
                        modifier = Modifier.width(100.dp)
                    )
                    Text(
                        text = "사용중인 이용권이 없습니다",
                        color = colorResource(R.color.my_text),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "티빙캐시",
                        color = colorResource(R.color.my_text),
                        modifier = Modifier.width(100.dp)
                    )
                    Text(
                        text = "0",
                        color = colorResource(R.color.my_text),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.my_menu_background))
                    .padding(20.dp)
            ){
                Column {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text="이용권을 구매하고",
                            color = colorResource(R.color.my_text)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Image(
                            painter = painterResource(R.drawable.tvn),
                            contentDescription = "tvN",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Image(
                            painter = painterResource(R.drawable.jtbc),
                            contentDescription = "JTBC",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(
                            text="등 인기 시리즈와",
                            color = colorResource(R.color.my_text)
                        )
                    }
                    Text(
                        text="다양한 영화 콘텐츠를 자유롭게 시청하세요!",
                        color = colorResource(R.color.my_text)
                    )
                }
                Image(
                    painter = painterResource(R.drawable.my_right_arrow),
                    contentDescription = "더보기",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(20.dp),
                    alignment = Alignment.CenterEnd
                )
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "이용권 구독",
                    color = colorResource(R.color.my_text),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "회원정보 수정",
                    color = colorResource(R.color.my_text),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "프로모션 정보 수신 동의",
                    color = colorResource(R.color.my_text),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "다운로드",
                        color = colorResource(R.color.my_text),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "다운로드 콘텐츠는 이 곳에서 시청할 수 있어요",
                        color = colorResource(R.color.my_sub_text),
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "라이브 예약 알림",
                    color = colorResource(R.color.my_text),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "고객 센터",
                    color = colorResource(R.color.my_text),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "공지사항",
                    color = colorResource(R.color.my_text),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "이벤트",
                    color = colorResource(R.color.my_text),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
            }

            val context = LocalContext.current
            OutlinedButton(
                onClick = {
                    // 로그인 정보 제거
                    val sharedPref = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        clear() // 모든 저장값 제거
                        apply()
                    }
                    Toast.makeText(context, "로그아웃 되었습니다", Toast.LENGTH_SHORT).show()

                    // 로그인 화면으로 이동
                    val intent = Intent(context, SignInActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "로그아웃",
                    color = colorResource(R.color.my_text)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMyView(){
    MyView("userId")
}
