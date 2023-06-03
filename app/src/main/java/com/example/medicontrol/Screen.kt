package com.example.medicontrol

sealed class Screen(val route: String) {
    object MedicationListScreen : Screen("medication_list_screen")
}
