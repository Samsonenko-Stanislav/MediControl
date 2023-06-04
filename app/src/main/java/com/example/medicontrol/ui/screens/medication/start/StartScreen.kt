package com.example.medicontrol.ui.screens.medication.start

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StartScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Введите свои данные", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = birthDate,
            onValueChange = { birthDate = it },
            label = { Text("Дата рождения") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Пол") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Screen.SettingsScreen.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Перейти к настройкам")
        }
    }
}