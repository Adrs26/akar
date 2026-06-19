package dev.adrian.akar.component.overlay

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import dev.adrian.akar.component.button.AkarButton
import dev.adrian.akar.component.button.AkarOutlinedButton
import dev.adrian.akar.component.container.AkarSpacer
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarAlertDialog(
    text: String,
    dismissLabel: String,
    confirmLabel: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = modifier,
            shape = AkarTheme.shapes.large,
            color = AkarTheme.colors.surface
        ) {
            Column(
                modifier = Modifier.padding(AkarTheme.spacing.medium)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text,
                        textAlign = TextAlign.Center,
                        style = AkarTheme.typography.labelFeatured
                    )
                }
                AkarSpacer(height = AkarTheme.spacing.medium)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(AkarTheme.spacing.small)
                ) {
                    AkarOutlinedButton(
                        label = dismissLabel,
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f)
                    )
                    AkarButton(
                        label = confirmLabel,
                        onClick = onConfirm,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}