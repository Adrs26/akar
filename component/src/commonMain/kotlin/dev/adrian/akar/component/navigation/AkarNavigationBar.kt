package dev.adrian.akar.component.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarNavigationBar(
    items: List<AkarNavigationBarItem>,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = AkarTheme.colors.surface
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.selected,
                onClick = item.onClick,
                icon = {

                },
                label = {
                    Text(
                        text = item.label,
                        style = if (item.selected) AkarTheme.typography.labelFeatured else
                            AkarTheme.typography.labelStandard
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = AkarTheme.colors.primary.copy(alpha = 0.25f),
                    selectedIconColor = AkarTheme.colors.onSurface,
                    unselectedIconColor = AkarTheme.colors.onSurface
                )
            )
        }
    }
}

data class AkarNavigationBarItem(
    val selected: Boolean,
    val onClick: () -> Unit,
    val icon: Char,
    val label: String
)