package com.example.startandroid.adddelete

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AddDeleteGridScreen(navController: NavController, nums: List<Int>, onUpdateNum: (List<Int>) -> Unit) {
    val coral = Color(0xFFFAB398)
    val lightPurple = Color(0xFFEADDFF)
    val purple = Color(0xFF66558F)
    val orange = Color(0xFFFFA938)

    Box(
        modifier = Modifier
            .padding(bottom = 81.dp),

        ) {
        Box(
            modifier = Modifier
                .padding(bottom = 62.dp)
                .align(Alignment.BottomCenter)
        ) {
            Buttons(orange, Color.Black, "이동") {
                navController.popBackStack()
                onUpdateNum(nums.take(6))
            }
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Buttons(lightPurple, Color.Black, "삭제") {
                if (nums.size > 1){
                    onUpdateNum(nums.dropLast(1))
                }
            }
            Spacer(Modifier.width(40.dp))
            Buttons(purple, Color.White, "추가") {
                if (nums.size < 15)
                    onUpdateNum(nums + (nums.size+1))
            }

        }

    }

    LazyVerticalGrid(
        contentPadding = PaddingValues(30.dp),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        items(nums.size) { index ->
            Box(
                modifier = Modifier.size(80.dp)
            ) {
                Circle(coral, nums[index])
            }
        }
    }
}

@Composable
fun AddDeleteScreen2(navController: NavController, nums: List<Int>, onUpdateNum : (List<Int>)-> Unit) {
    val coral = Color(0xFFFAB398)
    val lightPurple = Color(0xFFEADDFF)
    val purple = Color(0xFF66558F)
    val orange = Color(0xFFFFA938)


    Box(
        modifier = Modifier
            .padding(bottom = 81.dp),

        ) {
        Box(
            modifier = Modifier
                .padding(bottom = 62.dp)
                .align(Alignment.BottomCenter)
        ) {
            Buttons(orange, Color.Black, "이동") {
                navController.navigate("add_delete_grid")
            }
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Buttons(lightPurple, Color.Black, "삭제") {
                if (nums.size > 1)
                    onUpdateNum(nums.dropLast(1))
            }
            Spacer(Modifier.width(40.dp))
            Buttons(purple, Color.White, "추가") {
                if (nums.size < 6)
                    onUpdateNum(nums + (nums.size+1))
            }
        }

    }

    LazyColumn(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(nums.size) { index ->
            Circle(coral, nums[index])
        }
    }

}

@Composable
fun AddDeleteNavGraph() {
    val navController = rememberNavController()
    var nums by rememberSaveable { mutableStateOf(listOf(1)) }

    NavHost(
        navController = navController,
        startDestination = "add_delete"
    ) {
        composable("add_delete") {
            AddDeleteScreen2 (navController, nums){ UpdateNum ->
                nums = UpdateNum
            }
        }
        composable("add_delete_grid") {
            AddDeleteGridScreen(navController, nums){ UpdateNum ->
                nums = UpdateNum
            }
        }
    }

}

@Preview
@Composable
fun AddDeleteGridScreenPreview() {
    AddDeleteNavGraph()
}