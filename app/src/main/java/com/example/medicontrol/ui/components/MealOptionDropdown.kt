package com.example.medicontrol.ui.components

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.example.medicontrol.model.MealOption

@Composable
fun MealOptionDropdown(
    mealOption: MealOption,
    onMealOptionChange: (MealOption) -> Unit
) {
    val options = listOf(
        MealOption.BEFORE_MEAL,
        MealOption.DURING_MEAL,
        MealOption.AFTER_MEAL,
        MealOption.INDEPENDENT_OF_MEAL
    )

    var expanded by remember { mutableStateOf(false) }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        options.forEach { option ->
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onMealOptionChange(option)
                }
            ) {
                Text(text = option.toString())
            }
        }
    }
}
