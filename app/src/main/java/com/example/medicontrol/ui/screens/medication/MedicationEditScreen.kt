package com.example.medicontrol.ui.screens.medication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.model.Medication
import com.example.medicontrol.ui.components.MedicationForm

@Composable
fun MedicationEditScreen(
    medicationId: Long,
    viewModel: MedicationViewModel,
    navigateUp: () -> Unit
) {
    val medication by viewModel.getMedication(medicationId).collectAsState()

    if (medication != null) {
        MedicationForm(
            medication = medication!!,
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
