package com.example.medicontrol.ui.screens.medication

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.model.Medication
import com.example.medicontrol.ui.components.MedicationList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicationListScreen(
    medications: List<Medication>,
    navigateToMedicationDetail: (Long) -> Unit,
    viewModel: MedicationViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Список лекарств") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToMedicationDetail(-1) },
                content = { Icon(Icons.Default.Add, contentDescription = "Добавить") }
            )
        },
        content = {
            if (medications.isNotEmpty()) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))
                    MedicationList(medications, navigateToMedicationDetail, viewModel)
                }
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Список лекарств пуст")
                }
            }
        }
    )
}