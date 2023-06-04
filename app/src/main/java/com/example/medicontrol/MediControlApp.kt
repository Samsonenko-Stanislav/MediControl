package com.example.medicontrol

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.medicontrol.dao.MedicationDao
import com.example.medicontrol.model.Medication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MediControlApp : Application() {
    private val database: MedicationDatabase by lazy { MedicationDatabase.getDatabase(this) }
    private val medicationDao: MedicationDao by lazy { database.medicationDao() }

    lateinit var medications: LiveData<List<Medication>>

    override fun onCreate() {
        super.onCreate()
        medications = runBlocking(Dispatchers.IO) {
            medicationDao.getAllMedications()
        }

        fun initializeMedications() {
            runBlocking {
                withContext(Dispatchers.IO) {
                    medications = medicationDao.getAllMedications()
                }
            }
        }
    }
}
