package dev.adrian.akar.component.layout

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.adrian.akar.core.theme.AkarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AkarAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    textColor: Color = AkarTheme.colors.onSurface,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = textColor,
                style = AkarTheme.typography.headingStandard
            )
        },
        modifier = modifier,
        navigationIcon = { navigationIcon?.invoke() },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(AkarTheme.colors.surface)
    )
}