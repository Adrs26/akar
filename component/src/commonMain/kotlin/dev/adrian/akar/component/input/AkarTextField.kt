package dev.adrian.akar.component.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarTextField(
    state: TextFieldState,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
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
            state = state,
            modifier = Modifier.fillMaxWidth(),
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
            lineLimits = TextFieldLineLimits.SingleLine,
            shape = AkarTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = AkarTheme.colors.surface,
                unfocusedIndicatorColor = AkarTheme.colors.outlineVariant,
                focusedContainerColor = AkarTheme.colors.surface,
                errorContainerColor = AkarTheme.colors.surface,
                errorIndicatorColor = AkarTheme.colors.error,
                errorSupportingTextColor = AkarTheme.colors.error
            )
        )
    }
}