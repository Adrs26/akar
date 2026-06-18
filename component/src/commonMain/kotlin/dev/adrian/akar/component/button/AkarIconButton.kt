package dev.adrian.akar.component.button

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import dev.adrian.akar.component.feedback.AkarIcon
import dev.adrian.akar.core.theme.AkarTheme
import kotlin.time.Clock

@Composable
fun AkarIconButton(
    icon: Char,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = AkarTheme.colors.onSurface,
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

    IconButton(
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
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = tint
        ),
        interactionSource = interactionSource
    ) {
        AkarIcon(
            icon = icon,
            contentDescription = contentDescription,
            modifier = Modifier,
            tint = tint
        )
    }
}