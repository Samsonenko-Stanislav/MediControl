package com.example.medicontrol.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.medicontrol.MedicationDatabase
import com.example.medicontrol.dao.MedicationDao
import com.example.medicontrol.model.Medication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MedicationViewModel(application: Application) : AndroidViewModel(application) {
    private val medicationDao: MedicationDao

    init {
        val database = MedicationDatabase.getDatabase(application)
        medicationDao = database.medicationDao()
    }

    fun getAllMedications(): LiveData<List<Medication>> {
        return medicationDao.getAllMedications()
    }

    fun getMedication(medicationId: Long): Flow<Medication?> {
        return medicationDao.getMedication(medicationId)
    }

    fun addMedication(medication: Medication) {
        viewModelScope.launch(Dispatchers.IO) {
            medicationDao.addMedication(medication)
        }
    }

    fun updateMedication(medication: Medication) {
        viewModelScope.launch(Dispatchers.IO) {
            medicationDao.updateMedication(medication)
        }
    }

    fun deleteMedication(medication: Medication) {
        viewModelScope.launch(Dispatchers.IO) {
            medicationDao.deleteMedication(medication)
        }
    }

    fun updateMedicationStatus(medication: Medication, isAccepted: Boolean) {
        medication.isAccepted = isAccepted
        medicationDao.updateMedication(medication)

    }

}