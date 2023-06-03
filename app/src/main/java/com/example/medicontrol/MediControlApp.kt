import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicontrol.Screen
import com.example.medicontrol.ui.MediControlTheme
import com.example.medicontrol.ui.screens.medication.MedicationListScreen

@Composable
fun MediControlApp() {
    MediControlTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.MedicationListScreen.route) {
            composable("medicationListScreen") {
                MedicationListScreen(
                    medications = emptyList(),
                    onMedicationClicked = {},
                    onMedicationSwiped = {},
                    navController = navController
                )
            }
        }
    }
}