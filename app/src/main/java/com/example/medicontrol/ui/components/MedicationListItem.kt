package com.example.medicontrol.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.medicontrol.ViewModel.MedicationViewModel
import kotlinx.coroutines.flow.filter

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MedicationListItem(
    medication: Int,
    navigateToMedicationDetail: (Long) -> Unit,
    viewModel: MedicationViewModel
) {
    val swipeableState = rememberSwipeableState(false)

    val color by animateColorAsState(
        if (medication.isAccepted) Color.LightGray else Color.White
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .swipeable(
                state = swipeableState,
                anchors = mapOf(0f to false, 1f to true),
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                orientation = Orientation.Horizontal
            )
            .offset { IntOffset(swipeableState.offset.value.toInt(), 0) }
            .background(color)
            .clickable { navigateToMedicationDetail(medication.id) },
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = medication.name, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Дозировка: ${medication.dosage}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Частота приема: ${medication.frequency}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Продолжительность приема: ${medication.duration} дней")

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = { viewModel.deleteMedication(medication) }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Удалить",
                    tint = Color.Red
                )
            }
        }
    }

    LaunchedEffect(swipeableState) {
        snapshotFlow { swipeableState.isAnimationRunning }
            .filter { !it }
            .collect {
                if (swipeableState.currentValue) {
                    viewModel.updateMedicationStatus(medication, !medication.isAccepted)
                }
            }
    }
}
