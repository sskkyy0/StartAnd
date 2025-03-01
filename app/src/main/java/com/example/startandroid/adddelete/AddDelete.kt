package com.example.startandroid.adddelete

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class AddDelete: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AddDeleteScreen()
        }
    }
}

@Composable
fun AddDeleteScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        AddDeleteComponent()
    }
}

@Composable
fun AddDeleteComponent(){
    val coral = Color(0xFFFAB398)
    val lightPurple = Color(0xFFEADDFF)
    val purple = Color(0xFF66558F)

    var nums by remember { mutableStateOf(listOf(1)) }
    Box(
        modifier = Modifier
            .padding(bottom = 81.dp),

    ){
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ){
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .width(100.dp)
                    .clip(shape = RoundedCornerShape(100.dp))
                ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = lightPurple,
                    contentColor = Color.Black
                ),
                onClick = {
                    if (nums.size>1)
                        nums = nums - (nums.last())
                },
            ) {
                Text("삭제")
            }
            Spacer(Modifier.width(40.dp))
            Button(
                modifier = Modifier
                    .height(40.dp)
                    .width(100.dp)
                    .clip(shape = RoundedCornerShape(100.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = purple
                ),
                onClick = {
                    if (nums.size<6)
                        nums = nums + (nums.size+1)
                }
            ) {
                Text("추가")
            }
        }

    }
    LazyColumn (
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        items(nums.size){ index ->
            Box(
                modifier = Modifier
                    .background(coral, shape = RoundedCornerShape(100.dp))
                    .size(80.dp),
            ){
                Text(
                    "${nums[index]}",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }

}

@Preview
@Composable
fun AddDeleteScreenPreview(){
    AddDeleteScreen()
}