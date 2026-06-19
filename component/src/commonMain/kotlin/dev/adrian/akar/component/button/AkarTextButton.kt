package dev.adrian.akar.component.button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarTextButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentColor: Color = AkarTheme.colors.primary
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(
            containerColor = AkarTheme.colors.surface,
            contentColor = contentColor
        )
    ) {
        Text(
            text = label,
            style = AkarTheme.typography.actionFeatured
        )
    }
}