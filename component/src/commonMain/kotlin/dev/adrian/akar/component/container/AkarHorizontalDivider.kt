package dev.adrian.akar.component.container

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarHorizontalDivider(
    modifier: Modifier = Modifier
) {
    HorizontalDivider(
        modifier = modifier,
        color = AkarTheme.colors.outline
    )
}