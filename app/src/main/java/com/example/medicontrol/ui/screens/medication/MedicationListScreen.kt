package com.example.medicontrol.ui.screens.medication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medicontrol.model.Medication
import com.example.medicontrol.ui.MedicationItem

@Composable
fun MedicationListScreen(
    medications: List<Medication>,
    onMedicationSwiped: (Medication) -> Unit,
    onMedicationClicked: (Medication) -> Unit,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Medications",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(medications) { medication ->
                MedicationItem(
                    medication = medication,
                    onMedicationSwiped = { onMedicationSwiped(medication) },
                    onMedicationClicked = { onMedicationClicked(medication) }
                )
            }
        }
    }
}