package dev.adrian.akar.component.feedback

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarIconBox(
    icon: Char,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    iconColor: Color = AkarTheme.colors.onPrimary,
    backgroundColor: Color = AkarTheme.colors.primary,
    supportingIcon: @Composable (BoxScope.() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .background(
                color = backgroundColor,
                shape = AkarTheme.shapes.medium
            ),
        contentAlignment = Alignment.Center
    ) {
        AkarIcon(
            icon = icon,
            contentDescription = contentDescription,
            tint = iconColor
        )
        supportingIcon?.let { iconContent ->
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(
                        x = AkarTheme.spacing.micro,
                        y = AkarTheme.spacing.micro
                    )
            ) {
                iconContent()
            }
        }
    }
}