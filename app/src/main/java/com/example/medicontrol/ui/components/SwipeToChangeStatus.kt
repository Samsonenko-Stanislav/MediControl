package com.example.medicontrol.ui.components

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SwipeableState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import com.example.medicontrol.model.Medication

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToChangeStatus(
    swipeableState: SwipeableState<Boolean>,
    medication: Medication,
    scaffoldState: ScaffoldState,
    onSave: (Medication) -> Unit,
    content: @Composable () -> Unit
) {
    val density = LocalDensity.current

    Box(
        modifier = Modifier
            .scrollable(
                orientation = Orientation.Vertical,
                state = swipeableState,
                enabled = !swipeableState.isAnimationRunning
            )
            .onGestured { change ->
                val offsetX = swipeableState.offset.value
                val delta = change.positionChange().x / density.density

                val newOffsetX = (offsetX + delta).coerceIn(-100f, 100f)

                val targetValue = if (newOffsetX > 0) 100f else -100f
                val targetAcceptance = newOffsetX > 0

                if (swipeableState.targetValue != targetValue) {
                    swipeableState.animateTo(
                        targetValue = targetValue,
                        animationSpec = swipeableSnapAnimation(
                            swipeableState,
                            targetValue
                        )
                    )
                }

                if (swipeableState.isAnimationRunning &&
                    swipeableState.offset.value == targetValue &&
                    medication.isAccepted != targetAcceptance
                ) {
                    medication.isAccepted = targetAcceptance
                    if (targetAcceptance) {
                        medication.quantity -= medication.dosage.value.toInt()
                    }

                    scaffoldState.snackbarHostState.showSnackbar(
                        message = if (targetAcceptance) "Лекарство принято" else "Лекарство отменено",
                        duration = SnackbarDuration.Short
                    )

                    onSave(medication)
                }
            }
    ) {
        content()
    }
}
