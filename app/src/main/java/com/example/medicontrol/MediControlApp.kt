import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MediControlApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.StartScreen.route) {
        composable(Screen.StartScreen.route) {
            StartScreen(navController)
        }
        composable(Screen.SettingsScreen.route) {
            SettingsScreen(navController)
        }
        composable(Screen.MedicationListScreen.route) {
            MedicationListScreen(navController)
        }
        composable(Screen.AddMedicationScreen.route) {
            AddMedicationScreen(navController)
        }
        composable(Screen.EditMedicationScreen.route) { backStackEntry ->
            val medicationId = backStackEntry.arguments?.getString("medicationId")
            EditMedicationScreen(navController, medicationId)
        }
        composable(Screen.BloodPressureScreen.route) {
            BloodPressureScreen(navController)
        }
        composable(Screen.GlucoseLevelScreen.route) {
            GlucoseLevelScreen(navController)
        }
    }
}

@Preview
@Composable
fun PreviewMediControlApp() {
    MediControlApp()
}
