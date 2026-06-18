package dev.adrian.akar.component.feedback

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.tclement.fonticons.FontIcon
import dev.tclement.fonticons.IconFont
import dev.tclement.fonticons.LocalIconFont
import dev.tclement.fonticons.LocalIconTint

@Composable
fun AkarIcon(
    icon: Char,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalIconTint.current,
    iconFont: IconFont = LocalIconFont.current
) {
    FontIcon(
        icon = icon,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint,
        iconFont = iconFont
    )
}