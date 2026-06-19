package dev.adrian.akar.component.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarLabeledCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .toggleable(
                value = checked,
                enabled = enabled,
                role = Role.Checkbox,
                onValueChange = onCheckedChange
            )
            .padding(vertical = AkarTheme.spacing.micro),
        horizontalArrangement = Arrangement.spacedBy(AkarTheme.spacing.extraSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = enabled && checked,
            onCheckedChange = null,
            modifier = Modifier.size(40.dp),
            enabled = enabled,
            colors = CheckboxDefaults.colors(
                uncheckedColor = AkarTheme.colors.outlineVariant,
                disabledUncheckedColor = AkarTheme.colors.outlineVariant.copy(alpha = 0.4f)
            )
        )
        Text(
            text = label,
            style = AkarTheme.typography.bodyStandard
        )
    }
}