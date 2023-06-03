package com.example.medicontrol.ui.components

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

    DropdownMenu {
        options.forEach { option ->
            DropdownMenuItem(
                onClick = {
                    onMealOptionChange(option)
                }
            ) {
                Text(text = option.toString())
            }
        }
    }
}
