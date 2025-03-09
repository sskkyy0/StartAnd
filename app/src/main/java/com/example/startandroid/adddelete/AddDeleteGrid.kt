package com.example.startandroid.adddelete

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddDeleteGridScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        AddDeleteGridComponent()

    }
}

@Composable
fun verticalArr(color: Color, nums: List<Int>) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(30.dp),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        items(nums.size) { index ->
            Box(
                modifier = Modifier.size(80.dp)
            )
            Circle(color, nums[index])

        }
    }
}

@Composable
fun horizonArr(color: Color, nums: List<Int>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(580.dp)
            .padding(30.dp)
    ){
        LazyHorizontalGrid(
            rows = GridCells.Fixed(6),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(nums.size) { index ->
                Box(
                    modifier = Modifier.size(80.dp)
                ){
                    Circle(color, nums[index])
                }
            }
        }
    }

}

@Composable
fun AddDeleteGridComponent() {
    val coral = Color(0xFFFAB398)
    val lightPurple = Color(0xFFEADDFF)
    val purple = Color(0xFF66558F)
    val orange = Color(0xFFFFA938)

    var nums by remember { mutableStateOf(listOf(1)) }
    var isGridRC by remember { mutableStateOf(true) }



    Box(
        modifier = Modifier
            .padding(bottom = 81.dp),

        ) {
        Box(
            modifier = Modifier
                .padding(bottom = 62.dp)
                .align(Alignment.BottomCenter)
        ) {
            buttons(orange, Color.Black, "이동") {
                if (nums.size > 6) nums = nums.take(6)
                isGridRC = !isGridRC
            }
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            buttons(lightPurple, Color.Black, "삭제") {
                if (nums.size > 1)
                    nums = nums - (nums.last())
            }
            Spacer(Modifier.width(40.dp))
            buttons(purple, Color.White, "추가") {
                if (nums.size < 15)
                    nums = nums + (nums.size + 1)
            }

        }

    }

    if (isGridRC) verticalArr(coral, nums)
    else horizonArr(coral, nums)
}

@Preview
@Composable
fun AddDeleteGridScreenPreview() {
    AddDeleteGridScreen()
}