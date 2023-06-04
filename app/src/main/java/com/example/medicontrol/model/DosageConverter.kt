package com.example.medicontrol.model

import androidx.room.TypeConverter
import com.example.medicontrol.model.Dosage
import com.google.gson.Gson

class DosageConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromDosage(dosage: Dosage): String {
        return gson.toJson(dosage)
    }

    @TypeConverter
    fun toDosage(json: String): Dosage {
        return gson.fromJson(json, Dosage::class.java)
    }
}
