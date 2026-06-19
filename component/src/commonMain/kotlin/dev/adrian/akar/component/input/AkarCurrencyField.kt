package dev.adrian.akar.component.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarCurrencyField(
    state: TextFieldState,
    onValueAsLongCent: (Long) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    val symbols = remember { getPlatformLocaleSymbols() }

    LaunchedEffect(state.text) {
        val input = state.text.toString()
        val formatted = input.toCleanedCurrency(symbols)

        if (formatted != input) {
            state.edit { replace(0, length, formatted) }
        }

        val numericString = formatted
            .replace(symbols.groupingSeparator.toString(), "")
            .replace(symbols.decimalSeparator.toString(), ".")

        val numericValue = numericString.toDoubleOrNull() ?: 0.0
        onValueAsLongCent((numericValue * 100).toLong())
    }

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
            placeholder = {
                Text(
                    text = "0",
                    style = AkarTheme.typography.bodyStandard
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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

private fun String.toCleanedCurrency(symbols: AkarLocaleSymbols): String {
    if (this.isEmpty()) return ""

    val groupingSep = symbols.groupingSeparator
    val decimalSep = symbols.decimalSeparator

    val cleaned = this.filter { it.isDigit() || it == decimalSep }

    val parts = cleaned.split(decimalSep)
    val intPart = parts[0].filter { it.isDigit() }
    val decimalPart = if (parts.size > 1) parts[1].take(2) else null

    val groupedInt = intPart.reversed()
        .chunked(3)
        .joinToString(groupingSep.toString())
        .reversed()

    return when {
        decimalPart != null -> "$groupedInt$decimalSep$decimalPart"
        cleaned.endsWith(decimalSep) -> "$groupedInt$decimalSep"
        else -> groupedInt
    }
}

data class AkarLocaleSymbols(
    val groupingSeparator: Char,
    val decimalSeparator: Char
)

expect fun getPlatformLocaleSymbols(): AkarLocaleSymbols