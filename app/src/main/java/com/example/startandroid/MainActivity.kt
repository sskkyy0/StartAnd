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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    private val num = 7 // 카드컴포넌트 개수를 상수로 설정
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // eclipse의 클릭 여부를 remember로 상태기억
            var isClicked by remember {
                mutableStateOf(false)
            }
            ProfileCardScreen()
            LazyColumn( // LazyColumn 안에 모든걸 해결하려고 하니 조금 지저분해보이긴 함
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val cardStates = List(num) { // 각각 카드의 상태를 리스트로 저장
                    mutableStateOf(false)
                }
                items(num) { index ->
                    ProfileCardComponent(
                        modifier = Modifier
                            .height(120.dp)
                            .width(160.dp),
                        isClicked = cardStates[index].value,
                        onTabClick = { newState ->
                            cardStates[index].value =
                                newState // 클릭하면 해당 인덱스의 값의 boolean 값 변경 -> newState
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileCardComponent(
    modifier: Modifier = Modifier,
    isClicked: Boolean,
    onTabClick: (Boolean) -> Unit
// 인자
) {
    val GreyColor = Color(0xFFD9D9D9) // 16진수 코드로 색깔 지정
    Card(
        // 카드 자체에 패딩, 둥근 모서리
        modifier = Modifier
            .padding(15.dp),
        shape = RoundedCornerShape(10.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = GreyColor
//        )
        // 이 방법은 chatGPT가 추천해줬는데, 내가 배운 background를 쓰는것보다 더 복잡해서 주석처리함
    ) {
        Box(
            // 크기, 배경색 설정
            modifier = Modifier
                .height(80.dp)
                .width(160.dp)
                .background(GreyColor),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box( // 박스에 패딩을 적용해야 내가 아는 패딩이 됨
                    modifier = Modifier.padding(10.dp)
                ) {
                    Card( // 카드에 패딩을 적용하면 카드 안 내용물에 패딩이 적용됨
                        modifier = Modifier
                            .size(40.dp)
                        //.padding(10.dp)
                        ,
                        shape = RoundedCornerShape(10.dp)
                    ) {
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
                        .padding(top = 13.dp),
                ) {
                    Text("이름: 김하늘", style = TextStyle(fontSize = 8.sp))
                    Spacer(Modifier.height(3.dp))
                    Text("학번: 202411276", style = TextStyle(fontSize = 8.sp))
                    Spacer(Modifier.height(3.dp))
                    Text("학과: 컴퓨터공학부", style = TextStyle(fontSize = 8.sp))
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd // 아이콘의 위치 오른쪽 아래
            ) {
                IconButton(
                    onClick = {
                        onTabClick(!isClicked) // 누르면 isClicked의 값 변경
                    },
                    modifier = Modifier.size(37.dp) // 아이콘버튼의 사이즈에 따라 아이콘의 위치가 바뀜...
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.eclipse1),
                        contentDescription = "eclipse",
                        modifier = Modifier
                            .size(15.dp),
                        tint = if (isClicked) Color.Black else Color.Red // true면 검은색, false면 빨간색
                    )
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
    val num=7
    var isClicked by remember {
        mutableStateOf(false)
    }
    ProfileCardScreen()
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val cardStates = List(num) {
            mutableStateOf(false)
        }
        items(num) { index ->
            ProfileCardComponent(
                modifier = Modifier
                    .height(120.dp)
                    .width(160.dp),
                isClicked = cardStates[index].value,
                onTabClick = { newState ->
                    cardStates[index].value =
                        newState
                }
            )
        }
    }
}