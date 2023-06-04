package com.example.medicontrol

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.medicontrol.dao.MedicationDao
import com.example.medicontrol.model.Medication

@Database(entities = [Medication::class], version = 1)
abstract class MedicationDatabase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao

    companion object {
        @Volatile
        private var INSTANCE: MedicationDatabase? = null

        fun getDatabase(context: Context): MedicationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MedicationDatabase::class.java,
                    "medication_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}