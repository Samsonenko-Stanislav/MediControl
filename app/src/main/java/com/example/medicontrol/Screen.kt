package com.example.medicontrol

import androidx.navigation.NavBackStackEntry

sealed class Screen(val route: String) {
    object MedicationList : Screen("medicationList")
    object MedicationEdit : Screen("medicationEdit/{medicationId}") {
        fun withArgs(medicationId: Long): String {
            return "medicationEdit/$medicationId"
        }

        fun extractArgs(backStackEntry: NavBackStackEntry): String? {
            return backStackEntry.arguments?.getString("medicationId")
        }
    }
    object MedicationAdd : Screen("medicationAdd")
}
