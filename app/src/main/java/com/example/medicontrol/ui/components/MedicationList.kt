package com.example.medicontrol.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.model.Medication
import com.example.medicontrol.ui.MedicationListItem

@Composable
fun MedicationList(
    medications: List<Medication>,
    navigateToMedicationDetail: (Long) -> Unit,
    viewModel: MedicationViewModel
) {
    LazyColumn {
        items(items = medications) { medication ->
            MedicationListItem(
                medication = medication,
                navigateToMedicationDetail = navigateToMedicationDetail,
                viewModel = viewModel
            )
        }
    }
}