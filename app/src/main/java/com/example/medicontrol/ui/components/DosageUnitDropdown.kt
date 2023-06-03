package com.example.medicontrol.ui.components

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.medicontrol.model.DosageUnit

@Composable
fun DosageUnitDropdown(
    dosageUnit: DosageUnit,
    onDosageUnitChange: (DosageUnit) -> Unit
) {
    val options = listOf(
        DosageUnit.TABLETS,
        DosageUnit.CAPSULES,
        DosageUnit.DROPS,
        DosageUnit.ML,
        DosageUnit.INHALATION,
        DosageUnit.DOSES
    )

    DropdownMenu {
        options.forEach { option ->
            DropdownMenuItem(
                onClick = {
                    onDosageUnitChange(option)
                }
            ) {
                Text(text = option.toString())
            }
        }
    }
}
