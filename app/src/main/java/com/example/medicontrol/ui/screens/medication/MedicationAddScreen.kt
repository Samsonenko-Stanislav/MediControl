package com.example.medicontrol.ui.components

import androidx.compose.runtime.Composable
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.model.Medication

@Composable
fun MedicationAddScreen(
    viewModel: MedicationViewModel,
    navigateUp: () -> Unit
) {
    val newMedication = Medication()

    MedicationForm(
        medication = newMedication,
        onSave = { medication ->
            viewModel.addMedication(medication)
            navigateUp()
        },
        onCancel = navigateUp
    )
}