package com.example.medicontrol.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.medicontrol.model.Medication

@Dao
interface MedicationDao {
    @Query("SELECT * FROM medications ORDER BY name ASC")
    fun getAllMedications(): LiveData<List<Medication>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMedication(medication: Medication)

    @Update
    fun updateMedication(medication: Medication)

    @Delete
    fun deleteMedication(medication: Medication)
}