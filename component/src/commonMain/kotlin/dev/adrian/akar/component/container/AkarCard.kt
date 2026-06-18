package dev.adrian.akar.component.container

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarCard(
    modifier: Modifier = Modifier,
    content: @Composable (ColumnScope.() -> Unit)
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(AkarTheme.colors.surface),
        elevation = CardDefaults.cardElevation(0.dp),
        border = BorderStroke(
            width = 1.dp,
            color = AkarTheme.colors.outline
        ),
        content = content
    )
}