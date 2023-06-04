package com.example.medicontrol.ui.screens.medication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.dp
import com.example.medicontrol.model.Medication
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissState
import androidx.compose.material.SwipeToDismiss

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MedicationItem(
    medication: Medication,
    onMedicationSwiped: () -> Unit,
    onMedicationClicked: () -> Unit
) {
    SwipeToDismiss(
        state = rememberDismissState(),
        directions = setOf(DismissDirection.StartToEnd),
        background = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(androidx.compose.ui.graphics.Color.Red),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Medication",
                    tint = androidx.compose.ui.graphics.Color.White,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        },
        dismissContent = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onMedicationClicked() }
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = medication.name,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = medication.isTaken,
                    onCheckedChange = { isChecked -> if (isChecked) onMedicationSwiped() },
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    )
}
