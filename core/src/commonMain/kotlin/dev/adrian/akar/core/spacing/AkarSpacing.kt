package dev.adrian.akar.core.spacing

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AkarSpacing(
    val none: Dp,
    val nano: Dp,
    val micro: Dp,
    val extraSmall: Dp,
    val small: Dp,
    val compact: Dp,
    val medium: Dp,
    val mediumLarge: Dp,
    val large: Dp,
    val extraLarge: Dp
)

val akarSpacing = AkarSpacing(
    none = 0.dp,
    nano = 1.dp,
    micro = 2.dp,
    extraSmall = 4.dp,
    small = 8.dp,
    compact = 12.dp,
    medium = 16.dp,
    mediumLarge = 20.dp,
    large = 24.dp,
    extraLarge = 32.dp
)

val LocalAkarSpacing = staticCompositionLocalOf<AkarSpacing> {
    error("No spacing provided")
}