package dev.adrian.akar.component.button

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.adrian.akar.core.theme.AkarTheme

@Composable
fun AkarButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = AkarTheme.colors.primary,
            contentColor = AkarTheme.colors.onPrimary
        )
    ) {
        Text(
            text = label,
            style = AkarTheme.typography.actionStandard
        )
    }
}