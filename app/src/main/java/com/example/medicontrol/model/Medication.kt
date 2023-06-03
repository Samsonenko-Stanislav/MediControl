package com.example.medicontrol.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.medicontrol.StringListConverter

@Entity(tableName = "medications")
@TypeConverters(StringListConverter::class)


data class Medication(
    val id: Long = 0L,
    var name: String = "",
    var dosage: Dosage = Dosage(),
    var frequency: Frequency = Frequency(),
    var duration: Int = 0,
    var mealOption: MealOption = MealOption.BEFORE_MEAL,
    var quantity: Int = 0,
    var isAccepted: Boolean = false
)







