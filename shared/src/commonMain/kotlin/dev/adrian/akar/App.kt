package dev.adrian.akar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.adrian.akar.component.button.AkarBottomActionButton
import dev.adrian.akar.component.button.AkarButton
import dev.adrian.akar.component.button.AkarFloatingActionButton
import dev.adrian.akar.component.button.AkarIconButton
import dev.adrian.akar.component.button.AkarOutlinedButton
import dev.adrian.akar.component.feedback.AkarIcon
import dev.adrian.akar.component.feedback.AkarIconBox
import dev.adrian.akar.component.feedback.AkarLinearProgress
import dev.adrian.akar.component.feedback.AkarSquircleProgress
import dev.adrian.akar.component.layout.AkarAppBar
import dev.adrian.akar.component.layout.AkarScaffold
import dev.adrian.akar.component.overlay.AkarDatePickerDialog
import dev.adrian.akar.component.overlay.AkarDateValidators
import dev.adrian.akar.core.theme.AkarTheme
import dev.adrian.akar.icon.AkarIcons

@Composable
@Preview
fun App() {
    val icon = AkarIcons.rememberIcon()
    val filledIcon = AkarIcons.rememberIcon(fill = true)

    var isDialogShown by remember { mutableStateOf(false) }

    AkarTheme(
        icon = icon
    ) {
        AkarScaffold(
            topBar = {
                AkarAppBar(
                    title = "Akar Design System",
                    actions = {
                        AkarIconButton(
                            icon = AkarIcons.ReceiptLong,
                            contentDescription = null,
                            onClick = { }
                        )
                        AkarIconButton(
                            icon = AkarIcons.Flag,
                            contentDescription = null,
                            onClick = { }
                        )
                        AkarIconButton(
                            icon = AkarIcons.Settings,
                            contentDescription = null,
                            onClick = { isDialogShown = true }
                        )
                    },
                    textColor = AkarTheme.colors.primary
                )
            },
            bottomBar = {
                AkarBottomActionButton(
                    label = "Press me",
                    onClick = { }
                )
            },
            floatingActionButton = {
                AkarFloatingActionButton(
                    icon = AkarIcons.Add2,
                    contentDescription = null,
                    onClick = {  }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
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
                    AkarIconButton(
                        icon = AkarIcons.Settings,
                        contentDescription = null,
                        onClick = {  }
                    )
                    AkarLinearProgress(
                        progress = 0.75f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = AkarTheme.spacing.large)
                    )
                    AkarSquircleProgress(
                        progress = 0.6f
                    )
                }
            }
        }

        if (isDialogShown) {
            AkarDatePickerDialog(
                dismissLabel = "Cancel",
                confirmLabel = "Save",
                onDismiss = { isDialogShown = false },
                onDateSelected = { isDialogShown = false },
                selectableDates = AkarDateValidators.maxToday()
            )
        }
    }
}