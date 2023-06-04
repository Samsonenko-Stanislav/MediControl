package com.example.medicontrol.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicontrol.model.Medication

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicationForm(
    medication: Medication,
    onSave: (Medication) -> Unit,
    onCancel: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Редактирование лекарства") },
                navigationIcon = {
                    IconButton(onClick = onCancel) {
                        Icon(Icons.Default.Done, contentDescription = "Отмена")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onSave(medication) },
                content = { Icon(Icons.Default.Done, contentDescription = "Сохранить") }
            )
        },
        content = {
            MedicationFormContent(medication = medication)
        }
    )
}
