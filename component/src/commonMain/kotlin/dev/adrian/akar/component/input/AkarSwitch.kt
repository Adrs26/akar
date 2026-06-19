package dev.adrian.akar.component.input

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier.height(24.dp),
        colors = SwitchDefaults.colors(
            checkedThumbColor = AkarTheme.colors.surface,
            checkedTrackColor = AkarTheme.colors.primary,
            uncheckedThumbColor = AkarTheme.colors.outlineVariant,
            uncheckedTrackColor = AkarTheme.colors.surface,
            uncheckedBorderColor = AkarTheme.colors.outlineVariant
        )
    )
}