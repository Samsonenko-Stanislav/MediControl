package com.example.medicontrol.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.model.Medication

@ExperimentalFoundationApi
@Composable
fun MedicationListScreen(
    medications: List<Medication>,
    navigateToMedicationDetail: (Long) -> Unit,
    navigateToMedicationAdd: () -> Unit,
    navigateToMedicationEdit: (Long) -> Unit,
    viewModel: MedicationViewModel
) {
    val navController = rememberNavController()

    Column(Modifier.padding(16.dp)) {
        Text(text = "Список лекарств", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navigateToMedicationAdd() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Добавить лекарство")
        }

        Spacer(modifier = Modifier.height(16.dp))

        medications.forEach { medication ->
            MedicationListItem(
                medication = medication,
                navigateToMedicationDetail = { navigateToMedicationDetail(it) },
                navigateToMedicationEdit = { navigateToMedicationEdit(it) },
                viewModel = viewModel
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MedicationListItem(
    medication: Medication,
    navigateToMedicationDetail: (Long) -> Unit,
    navigateToMedicationEdit: (Long) -> Unit,
    viewModel: MedicationViewModel
) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { navigateToMedicationDetail(medication.id) },
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = medication.name, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Дозировка: ${medication.dosage}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Частота приема: ${medication.frequency}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Продолжительность приема: ${medication.duration} дней")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navigateToMedicationEdit(medication.id) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Редактировать")
            }
        }
    }
}
