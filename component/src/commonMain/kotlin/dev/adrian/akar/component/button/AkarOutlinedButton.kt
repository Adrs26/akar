package dev.adrian.akar.component.button

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import dev.adrian.akar.core.theme.AkarTheme
import kotlin.time.Clock

@Composable
fun AkarOutlinedButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    var lastClickTime by remember { mutableLongStateOf(0L) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1.0f,
        animationSpec = spring(
            dampingRatio = 0.6f,
            stiffness = 400f
        ),
        label = "AkarButtonScaleAnimation"
    )

    OutlinedButton(
        onClick = {
            val currentTime = Clock.System.now().toEpochMilliseconds()
            if (currentTime - lastClickTime >= 700L) {
                lastClickTime = currentTime
                onClick()
            }
        },
        modifier = modifier.graphicsLayer {
            scaleX = scale
            scaleY = scale
        },
        interactionSource = interactionSource,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = AkarTheme.colors.surface,
            contentColor = AkarTheme.colors.onSurface
        ),
        border = BorderStroke(
            width = 1.dp,
            color = AkarTheme.colors.outline
        )
    ) {
        Text(
            text = label,
            style = AkarTheme.typography.actionStandard
        )
    }
}