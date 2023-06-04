package com.example.medicontrol.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.medicontrol.ViewModel.MedicationViewModel
import com.example.medicontrol.model.Medication
import com.example.medicontrol.ui.screens.medication.MedicationListScreen

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MedicationViewModel

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MedicationViewModel::class.java]

        setContent {
            MediControlTheme {
                // Определение состояния экрана и вызов MedicationListScreen
                val medications = viewModel.getAllMedications()
                MedicationListContent(medications, viewModel)
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MedicationListContent(
    medications: LiveData<List<Medication>>,
    viewModel: MedicationViewModel
) {
    MaterialTheme {
        MedicationListScreen(
            medications = medications,
            navigateToMedicationDetail = {},
            viewModel = viewModel
        )
    }
}


