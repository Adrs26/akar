package dev.adrian.akar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import dev.adrian.akar.component.input.AkarCurrencyField
import dev.adrian.akar.component.input.AkarDisableField
import dev.adrian.akar.component.input.AkarPickerField
import dev.adrian.akar.component.input.AkarSwitch
import dev.adrian.akar.component.input.AkarTextField
import dev.adrian.akar.component.layout.AkarAppBar
import dev.adrian.akar.component.layout.AkarScaffold
import dev.adrian.akar.component.list.AkarLazyColumn
import dev.adrian.akar.component.list.add
import dev.adrian.akar.component.overlay.AkarDatePickerDialog
import dev.adrian.akar.component.overlay.AkarDateValidators
import dev.adrian.akar.core.theme.AkarTheme
import dev.adrian.akar.icon.AkarIcons

@Composable
fun App() {
    val icon = AkarIcons.rememberIcon()
    val filledIcon = AkarIcons.rememberIcon(fill = true)

    var isDialogShown by remember { mutableStateOf(false) }
    var checked by rememberSaveable { mutableStateOf(false) }

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
            AkarLazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = innerPadding.add(
                    start = AkarTheme.spacing.medium,
                    top = AkarTheme.spacing.medium,
                    end = AkarTheme.spacing.medium
                ),
                verticalArrangement = Arrangement.spacedBy(AkarTheme.spacing.large),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
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
                }
                item {
                    AkarButton(
                        label = "Press me",
                        onClick = {  }
                    )
                }
                item {
                    AkarOutlinedButton(
                        label = "Press me",
                        onClick = {  }
                    )
                }
                item {
                    AkarIconButton(
                        icon = AkarIcons.Settings,
                        contentDescription = null,
                        onClick = {  }
                    )
                }
                item {
                    AkarLinearProgress(
                        progress = 0.75f,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                item {
                    AkarSquircleProgress(
                        progress = 0.6f
                    )
                }
                item {
                    AkarTextField(
                        state = rememberTextFieldState(),
                        label = "Username",
                        placeholder = "Enter username"
                    )
                }
                item {
                    AkarCurrencyField(
                        state = rememberTextFieldState(),
                        onValueAsLongCent = {  },
                        label = "Amount"
                    )
                }
                item {
                    AkarPickerField(
                        value = "19 June 2026",
                        label = "Date",
                        onClick = {  },
                        trailingIcon = {
                            AkarIcon(
                                icon = AkarIcons.DateRange,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    )
                }
                item {
                    AkarDisableField(
                        value = "20,000,000",
                        label = "Amount"
                    )
                }
                item {
                    AkarSwitch(
                        checked = checked,
                        onCheckedChange = { checked = it }
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