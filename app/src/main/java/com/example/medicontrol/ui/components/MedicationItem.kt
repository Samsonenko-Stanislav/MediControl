package com.example.medicontrol.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.medicontrol.model.Medication

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MedicationItem(
    medication: Medication,
    onMedicationSwiped: () -> Unit,
    onMedicationClicked: () -> Unit
) {
    val dismissState = rememberDismissState()

    SwipeToDismiss(
        state = dismissState,
        directions = setOf(DismissDirection.StartToEnd),
        background = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Medication",
                    tint = Color.White,
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
