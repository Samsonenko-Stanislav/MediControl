package com.example.medicontrol.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicontrol.model.Frequency

@Composable
fun FrequencyInput(
    frequency: Frequency,
    onFrequencyChange: (Frequency) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = frequency.value.toString(),
            onValueChange = { frequency.value = it.toIntOrNull() ?: 0 },
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        FrequencyUnitDropdown(
            frequencyUnit = frequency.unit,
            onFrequencyUnitChange = { frequency.unit = it }
        )
    }
}
