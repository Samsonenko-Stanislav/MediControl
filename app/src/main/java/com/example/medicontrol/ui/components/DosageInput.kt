package com.example.medicontrol.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicontrol.model.Dosage

@Composable
fun DosageInput(
    dosage: Dosage,
    onDosageChange: (Dosage) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = dosage.value.toString(),
            onValueChange = { dosage.value = it.toFloatOrNull() ?: 0F },
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        DosageUnitDropdown(
            dosageUnit = dosage.unit,
            onDosageUnitChange = { dosage.unit = it }
        )
    }
}