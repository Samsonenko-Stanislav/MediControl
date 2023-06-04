package com.example.medicontrol.ui.components

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.medicontrol.model.FrequencyUnit

@Composable
fun FrequencyUnitDropdown(
    frequencyUnit: FrequencyUnit,
    onFrequencyUnitChange: (FrequencyUnit) -> Unit
) {
    val options = listOf(
        FrequencyUnit.TIMES_PER_DAY,
        FrequencyUnit.TIMES_PER_WEEK
    )

    DropdownMenu(
        expanded = false,
        onDismissRequest = {}
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                onClick = {
                    onFrequencyUnitChange(option)
                }
            ) {
                Text(text = option.toString())
            }
        }
    }
}
