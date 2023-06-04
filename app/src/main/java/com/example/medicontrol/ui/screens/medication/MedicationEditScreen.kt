package com.example.medicontrol.ui.screens.medication

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.ui.components.MedicationForm

@Composable
fun MedicationEditScreen(
    medicationId: Long,
    viewModel: MedicationViewModel,
    navigateUp: () -> Unit
) {
    val medicationState by viewModel.getMedication(medicationId).collectAsState(initial = null)

    val medication = medicationState

    if (medication != null) {
        MedicationForm(
            medication = medication,
            onSave = { updatedMedication ->
                viewModel.updateMedication(updatedMedication)
                navigateUp()
            },
            onCancel = navigateUp
        )
    } else {
        Text(text = "Лекарство не найдено")
    }
}
