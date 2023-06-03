package com.example.medicontrol.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.unit.dp
import com.example.medicontrol.model.Medication
import java.lang.reflect.Array.set

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MedicationForm(
    medication: Medication,
    onSave: (Medication) -> Unit,
    onCancel: () -> Unit
) {
    val swipeableState = rememberSwipeableState(false)
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
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
            SwipeToChangeStatus(
                swipeableState = swipeableState,
                medication = medication,
                scaffoldState = scaffoldState,
                onSave = onSave
            ) {
                MedicationFormContent(medication = medication)
            }
        }
    )
}