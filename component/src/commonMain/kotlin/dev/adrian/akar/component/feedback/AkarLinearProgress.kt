package dev.adrian.akar.component.feedback

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarLinearProgress(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = AkarTheme.colors.primary,
    trackColor: Color = AkarTheme.colors.surfaceVariant,
    strokeWidth: Dp = 10.dp,
    showPercentage: Boolean = true,
    textStyle: TextStyle = AkarTheme.typography.numberSubtle
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        animationSpec = spring(stiffness = Spring.StiffnessLow),
        label = "AkarLinearProgressAnimation"
    )

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(AkarTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .weight(1f)
                .height(strokeWidth)
        ) {
            val strokeWidthPx = strokeWidth.toPx()
            val cornerRadiusPx = 4.dp.toPx()
            val width = size.width

            drawRoundRect(
                color = trackColor,
                topLeft = Offset(0f, 0f),
                size = Size(width, strokeWidthPx),
                cornerRadius = CornerRadius(cornerRadiusPx, cornerRadiusPx)
            )

            if (animatedProgress > 0f) {
                val progressWidth = width * animatedProgress
                drawRoundRect(
                    color = color,
                    topLeft = Offset(0f, 0f),
                    size = Size(progressWidth, strokeWidthPx),
                    cornerRadius = CornerRadius(cornerRadiusPx, cornerRadiusPx)
                )
            }
        }
        if (showPercentage) {
            Text(
                text = "${(animatedProgress * 100).toInt()}%",
                style = textStyle.copy(color = color)
            )
        }
    }
}