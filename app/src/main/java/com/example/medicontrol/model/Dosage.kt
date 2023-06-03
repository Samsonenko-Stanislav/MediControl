package com.example.medicontrol.model

data class Dosage(
    var value: Float = 0F,
    var unit: DosageUnit = DosageUnit.TABLETS
)
