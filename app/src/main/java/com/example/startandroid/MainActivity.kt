package com.example.startandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.Style
import com.example.startandroid.ui.theme.StartAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardScreen()
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                items(7){
                    ProfileCardComponent(
                        modifier = Modifier
                            .height(120.dp)
                            .width(160.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileCardComponent(
    modifier: Modifier = Modifier,
// 인자
) {
    val GreyColor = Color(0xFFD9D9D9) // 16진수 코드로 색깔 지정
    Card( // 카드 자체에 패딩, 둥근 모서리, 배경색 설정
        modifier = Modifier
            .padding(15.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = GreyColor
        )
    ) {
        Box(
            modifier = Modifier
                .height(80.dp)
                .width(160.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box( // 박스에 패딩을 적용해야 내가 아는 패딩이 됨
                    modifier = Modifier.padding(10.dp)
                ){
                    Card( // 카드에 패딩을 적용하면 카드 안 내용물에 패딩이 적용됨
                        modifier = Modifier
                            .size(40.dp)
                        //.padding(10.dp)
                        ,
                        shape = RoundedCornerShape(10.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.robot),
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.Crop
                        )
                    }
                }


                //Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 10.dp) // 원래 간격은 13인데, 옆에 이미지랑 높이 맞춤
                    ,
                ) {
                    Text("이름: 김하늘", style = TextStyle(fontSize = 8.sp))
                    Spacer(Modifier.height(3.dp))
                    Text("학번: 202411276", style = TextStyle(fontSize = 8.sp))
                    Spacer(Modifier.height(3.dp))
                    Text("학과: 컴퓨터공학부", style = TextStyle(fontSize = 8.sp))
                }

            }

        }
    }
}

@Composable
fun ProfileCardScreen() {
    // 흰색 배경
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

    }
}


@Preview(showBackground = true)
@Composable
private fun ProfileCardPreview(

) {
    ProfileCardScreen()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(7){
            ProfileCardComponent(
                modifier = Modifier
                    .height(120.dp)
                    .width(160.dp)
            )
        }
    }
}