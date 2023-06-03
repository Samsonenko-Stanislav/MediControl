package com.example.medicontrol
import MediControlApp
import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicontrol.Screen
import com.example.medicontrol.ui.MediControlTheme
import com.example.medicontrol.ui.screens.medication.MedicationListScreen



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
