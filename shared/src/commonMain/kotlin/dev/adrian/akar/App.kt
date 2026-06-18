package dev.adrian.akar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.adrian.akar.component.button.AkarButton
import dev.adrian.akar.component.button.AkarOutlinedButton
import dev.adrian.akar.component.feedback.AkarIcon
import dev.adrian.akar.component.feedback.AkarIconBox
import dev.adrian.akar.core.theme.AkarTheme
import dev.adrian.akar.icon.AkarIcons

@Composable
@Preview
fun App() {
    val icon = AkarIcons.rememberIcon()
    val filledIcon = AkarIcons.rememberIcon(fill = true)

    AkarTheme(
        icon = icon
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(AkarTheme.spacing.medium),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AkarIconBox(
                    icon = AkarIcons.EmojiFoodBeverage,
                    contentDescription = null,
                    supportingIcon = {
                        AkarIcon(
                            icon = AkarIcons.Lock,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            iconFont = filledIcon
                        )
                    }
                )
                AkarButton(
                    label = "Press me",
                    onClick = {  }
                )
                AkarOutlinedButton(
                    label = "Press me",
                    onClick = {  }
                )
            }
        }
    }
}