package com.example.medicontrol.model

data class Frequency(
    var value: Int = 0,
    var unit: FrequencyUnit = FrequencyUnit.TIMES_PER_DAY
)
