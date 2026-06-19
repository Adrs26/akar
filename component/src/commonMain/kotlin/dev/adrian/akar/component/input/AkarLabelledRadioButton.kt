package dev.adrian.akar.component.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarLabeledRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .selectable(
                selected = selected,
                enabled = enabled,
                onClick = onClick
            )
            .padding(vertical = AkarTheme.spacing.micro),
        horizontalArrangement = Arrangement.spacedBy(AkarTheme.spacing.extraSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = null,
            modifier = Modifier.size(40.dp),
            enabled = enabled,
            colors = RadioButtonDefaults.colors(
                unselectedColor = AkarTheme.colors.outlineVariant
            )
        )
        Text(
            text = label,
            style = AkarTheme.typography.bodyStandard
        )
    }
}