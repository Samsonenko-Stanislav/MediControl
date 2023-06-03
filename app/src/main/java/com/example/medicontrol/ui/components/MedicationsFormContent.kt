package com.example.medicontrol.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicontrol.model.Medication

@Composable
fun MedicationFormContent(medication: Medication) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Название лекарства",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface
        )
        TextField(
            value = medication.name,
            onValueChange = { medication.name = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Дозировка",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface
        )
        DosageInput(
            dosage = medication.dosage,
            onDosageChange = { medication.dosage = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Частота приема",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface
        )
        FrequencyInput(
            frequency = medication.frequency,
            onFrequencyChange = { medication.frequency = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Продолжительность приема (в днях)",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface
        )
        TextField(
            value = medication.duration.toString(),
            onValueChange = { medication.duration = it.toIntOrNull() ?: 0 },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Количество купленного лекарства",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface
        )
        TextField(
            value = medication.quantity.toString(),
            onValueChange = { medication.quantity = it.toIntOrNull() ?: 0 },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Зависимость от еды",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface
        )
        MealOptionDropdown(
            mealOption = medication.mealOption,
            onMealOptionChange = { medication.mealOption = it }
        )
    }
}