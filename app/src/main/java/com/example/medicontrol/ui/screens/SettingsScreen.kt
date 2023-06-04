package com.example.medicontrol.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    name: String,
    dateOfBirth: String,
    gender: String,
    onNameChanged: (String) -> Unit,
    onDateOfBirthChanged: (String) -> Unit,
    onGenderChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { onNameChanged(it) },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = dateOfBirth,
            onValueChange = { onDateOfBirthChanged(it) },
            label = { Text("Date of Birth") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = gender,
            onValueChange = { onGenderChanged(it) },
            label = { Text("Gender") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
