package com.example.medicontrol.model

import androidx.room.TypeConverter
import com.example.medicontrol.model.Frequency
import com.google.gson.Gson

class FrequencyConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromFrequency(frequency: Frequency): String {
        return gson.toJson(frequency)
    }

    @TypeConverter
    fun toFrequency(json: String): Frequency {
        return gson.fromJson(json, Frequency::class.java)
    }
}