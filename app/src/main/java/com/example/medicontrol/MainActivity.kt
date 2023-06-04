package com.example.medicontrol

import MediControlApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.medicontrol.ui.MediControlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediControlTheme {
                MediControlApp()
            }
        }
    }
}