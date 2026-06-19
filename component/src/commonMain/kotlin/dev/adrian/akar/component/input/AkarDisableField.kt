package dev.adrian.akar.component.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.adrian.akar.component.feedback.AkarIcon
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarDisableField(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(AkarTheme.spacing.extraSmall)
    ) {
        Text(
            text = label,
            style = AkarTheme.typography.titleSubtle
        )
        OutlinedTextField(
            value = value,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            enabled = false,
            textStyle = AkarTheme.typography.bodyStandard,
            trailingIcon = {
                AkarIcon(
                    icon = '\ue88d',
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = AkarTheme.colors.onSurface.copy(alpha = 0.4f)
                )
            },
            supportingText = if (isError && errorMessage != null) {
                {
                    Text(
                        text = errorMessage,
                        style = AkarTheme.typography.captionStandard
                    )
                }
            } else {
                null
            },
            isError = isError,
            shape = AkarTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                disabledContainerColor = AkarTheme.colors.surface,
                disabledIndicatorColor = if (isError) AkarTheme.colors.error else
                    AkarTheme.colors.outlineVariant.copy(alpha = 0.4f),
                disabledTextColor = AkarTheme.colors.onSurface.copy(alpha = 0.4f),
                disabledSupportingTextColor = AkarTheme.colors.error
            )
        )
    }
}