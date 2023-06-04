package com.example.medicontrol.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.medicontrol.model.DosageUnit

@Composable
fun DosageUnitDropdown(
    dosageUnit: DosageUnit,
    onDosageUnitChange: (DosageUnit) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf(
        DosageUnit.TABLETS,
        DosageUnit.CAPSULES,
        DosageUnit.DROPS,
        DosageUnit.ML,
        DosageUnit.INHALATION,
        DosageUnit.DOSES
    )

    val onDismissRequest = { expanded = false }

    Box {
        Text(
            text = dosageUnit.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.clickable { expanded = true }
        )
        if (expanded) {
            Popup(
                alignment = Alignment.TopStart,
                onDismissRequest = onDismissRequest,
                properties = PopupProperties(focusable = false)
            ) {
                Column {
                    options.forEach { option ->
                        DropdownMenuItem(
                            onClick = {
                                onDosageUnitChange(option)
                                expanded = false
                            }
                        ) {
                            Text(text = option.toString())
                        }
                    }
                }
            }
        }
    }
}
