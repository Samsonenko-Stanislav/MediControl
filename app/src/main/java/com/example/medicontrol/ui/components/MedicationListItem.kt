package com.example.medicontrol.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.model.Medication

@Composable
fun MedicationListItem(
    medication: Medication,
    navigateToMedicationDetail: (Long) -> Unit,
    viewModel: MedicationViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { navigateToMedicationDetail(medication.id) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = medication.name, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Дозировка: ${medication.dosage}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Частота приема: ${medication.frequency}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Продолжительность приема: ${medication.duration} дней")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            IconButton(
                onClick = { viewModel.deleteMedication(medication) },
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Удалить",
                    tint = Color.Red
                )
            }
        }
    }
}
