package com.example.medicontrol.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.medicontrol.StringListConverter

@Entity(tableName = "medications")
@TypeConverters(StringListConverter::class)
data class Medication(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val dosage: String,
    val frequency: String,
    val duration: String,
    val purchasedCount: Int,
    val foodDependency: String,
    val medicationTimes: List<String> = emptyList(),
    val isTaken: Boolean
)