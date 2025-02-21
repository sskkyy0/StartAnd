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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.startandroid.ui.theme.StartAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileCardScreen()
            ProfileCardComponent(
                modifier = Modifier
                    .height(120.dp)
                    .width(160.dp)
            )
        }
    }
}

@Composable
fun ProfileCardComponent(
    modifier: Modifier = Modifier,

){
    val GreyColor = Color(0xFFD9D9D9)
    Card(
        modifier = Modifier
            .padding(15.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = GreyColor)
    ) {
        Box(
            modifier = Modifier
                .height(80.dp)
                .width(160.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ){
                Image(
                    painter = painterResource(id= R.drawable.robot),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(40.dp)
//                        .padding(10.dp)
                        ,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 10.dp),
                    verticalArrangement = Arrangement.Center
                ){
                    Text("이름: 김하늘")
                    Text("학번: 202411276")
                    Text("학과: 컴퓨터공학부")
                }

            }
        }
    }
}

@Composable
fun ProfileCardScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){

    }
}


@Preview(showBackground = true)
@Composable
private fun ProfileCardPreview(

    ){
    ProfileCardScreen()
    ProfileCardComponent(
        modifier = Modifier
            .height(80.dp)
            .width(160.dp)
            .padding(16.dp)
    )
}