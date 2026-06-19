package dev.adrian.akar.component.overlay

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.adrian.akar.component.feedback.AkarIcon
import dev.adrian.akar.core.theme.AkarTheme
import dev.adrian.akar.icon.AkarIcons

@Composable
fun <T : DropdownOption> AkarDropdownMenu(
    placeholder: String,
    options: List<T>,
    selectedOption: T?,
    onOptionSelected: (T) -> Unit,
    modifier: Modifier = Modifier,
    maxHeight: Dp = 150.dp
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
    ) {
        DropdownField(
            placeholder = placeholder,
            expanded = expanded,
            modifier = Modifier.clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.heightIn(max = maxHeight),
            shape = AkarTheme.shapes.small,
            containerColor = AkarTheme.colors.surface
        ) {
            options.forEach { option ->
                val isSelected = option.id == selectedOption?.id

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onOptionSelected(option)
                            expanded = false
                        }
                        .padding(vertical = 6.dp)
                        .padding(
                            start = AkarTheme.spacing.small,
                            end = AkarTheme.spacing.compact
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AkarIcon(
                        icon = AkarIcons.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = AkarTheme.spacing.small),
                        tint = if (isSelected) AkarTheme.colors.primary else
                            AkarTheme.colors.onSurface
                    )
                    Text(
                        text = option.label,
                        style = AkarTheme.typography.actionSubtle
                    )
                }
            }
        }
    }
}

@Composable
private fun DropdownField(
    placeholder: String,
    expanded: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = AkarTheme.colors.outline,
                shape = AkarTheme.shapes.small
            )
            .padding(
                start = AkarTheme.spacing.medium,
                top = AkarTheme.spacing.micro,
                end = AkarTheme.spacing.small,
                bottom = AkarTheme.spacing.micro
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = placeholder,
            style = AkarTheme.typography.actionSubtle.copy(
                color = AkarTheme.colors.onSurface
            )
        )
        AkarIcon(
            icon = AkarIcons.Check,
            contentDescription = null,
            modifier = Modifier
                .size(22.dp)
                .padding(start = AkarTheme.spacing.extraSmall)
                .rotateOn(expanded)
        )
    }
}

interface DropdownOption {
    val id: Int
    @get:Composable
    val label: String
}

fun Modifier.rotateOn(
    active: Boolean,
    activeRotation: Float = 180f,
    inactiveRotation: Float = 0f
): Modifier = composed {
    val rotation by animateFloatAsState(
        targetValue = if (active) activeRotation else inactiveRotation,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "RotationAnimation"
    )

    this.rotate(rotation)
}