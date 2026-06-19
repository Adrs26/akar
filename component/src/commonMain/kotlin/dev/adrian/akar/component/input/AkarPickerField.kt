package dev.adrian.akar.component.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarPickerField(
    value: String,
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String?= null
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
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onClick
                ),
            enabled = false,
            textStyle = AkarTheme.typography.bodyStandard,
            placeholder = placeholder?.let { placeholder ->
                {
                    Text(
                        text = placeholder,
                        style = AkarTheme.typography.bodyStandard.copy(
                            color = AkarTheme.colors.onSurfaceVariant
                        )
                    )
                }
            },
            trailingIcon = trailingIcon,
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
            maxLines = 1,
            shape = AkarTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                disabledContainerColor = AkarTheme.colors.surface,
                disabledIndicatorColor = when {
                    isError -> AkarTheme.colors.error
                    else -> AkarTheme.colors.outlineVariant
                },
                disabledTextColor = AkarTheme.colors.onSurface,
                disabledSupportingTextColor = AkarTheme.colors.error
            )
        )
    }
}