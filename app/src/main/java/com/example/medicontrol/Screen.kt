package com.example.medicontrol

import androidx.navigation.NavBackStackEntry

sealed class Screen(val route: String) {
    object StartScreen : Screen("start_screen")
    object SettingsScreen : Screen("settings_screen")
    object MedicationListScreen : Screen("medication_list_screen")
    object AddMedicationScreen : Screen("add_medication_screen")
    object EditMedicationScreen : Screen("edit_medication_screen/{medicationId}") {
        fun createRoute(medicationId: String): String {
            return "edit_medication_screen/$medicationId"
        }
    }
    object BloodPressureScreen : Screen("blood_pressure_screen")
    object GlucoseLevelScreen : Screen("glucose_level_screen")
}
