package dev.adrian.akar.component.feedback

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarSquircleProgress(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = AkarTheme.colors.primary,
    trackColor: Color = AkarTheme.colors.surfaceVariant,
    strokeWidth: Dp = 4.dp,
    cornerRadius: Dp = 16.dp,
    showPercentage: Boolean = true,
    textStyle: TextStyle = AkarTheme.typography.numberSubtle
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        animationSpec = spring(stiffness = Spring.StiffnessLow),
        label = "SquareProgressAnimation"
    )

    Box(
        modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = modifier.size(48.dp)
        ) {
            val strokeWidthPx = strokeWidth.toPx()
            val cornerRadiusPx = cornerRadius.toPx()
            val w = size.width
            val h = size.height

            val path = Path().apply {
                moveTo(w / 2f, 0f)

                lineTo(w - cornerRadiusPx, 0f)
                arcTo(
                    rect = Rect(w - cornerRadiusPx * 2, 0f, w, cornerRadiusPx * 2),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                lineTo(w, h - cornerRadiusPx)
                arcTo(
                    rect = Rect(w - cornerRadiusPx * 2, h - cornerRadiusPx * 2, w, h),
                    startAngleDegrees = 0f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                lineTo(cornerRadiusPx, h)
                arcTo(
                    rect = Rect(0f, h - cornerRadiusPx * 2, cornerRadiusPx * 2, h),
                    startAngleDegrees = 90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                lineTo(0f, cornerRadiusPx)
                arcTo(
                    rect = Rect(0f, 0f, cornerRadiusPx * 2, cornerRadiusPx * 2),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )

                close()
            }

            drawPath(
                path = path,
                color = trackColor,
                style = Stroke(width = strokeWidthPx)
            )

            val pathMeasure = PathMeasure()

            pathMeasure.setPath(path, forceClosed = false)
            val pathLength = pathMeasure.length

            val segmentPath = Path()

            pathMeasure.getSegment(
                startDistance = 0f,
                stopDistance = pathLength * animatedProgress,
                destination = segmentPath,
                startWithMoveTo = true
            )

            drawPath(
                path = segmentPath,
                color = color,
                style = Stroke(
                    width = strokeWidthPx,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round
                )
            )
        }

        if (showPercentage) {
            Text(
                text = "${(animatedProgress * 100).toInt()}%",
                style = textStyle.copy(color = color)
            )
        }
    }
}