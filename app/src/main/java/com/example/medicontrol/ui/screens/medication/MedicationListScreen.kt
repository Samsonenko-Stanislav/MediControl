package com.example.medicontrol.ui.screens.medication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.model.Medication
import com.example.medicontrol.ui.components.MedicationListItem

@Composable
fun MedicationListScreen(
    medications: LiveData<List<Medication>>,
    navigateToMedicationDetail: (Long) -> Unit,
    viewModel: MedicationViewModel
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
    ) {
        items(medications) { medication ->
            MedicationListItem(
                medication = medication,
                navigateToMedicationDetail = navigateToMedicationDetail,
                viewModel = viewModel
            )
        }
    }
}
