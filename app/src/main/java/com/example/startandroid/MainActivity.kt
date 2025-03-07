package com.example.startandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.startandroid.adddelete.AddDeleteGridScreen
import com.example.startandroid.adddelete.AddDeleteScreen
import com.example.startandroid.profilecard.ProfileCardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ProfileCardScreen()
            //AddDeleteScreen()
            AddDeleteGridScreen()
        }
    }
}