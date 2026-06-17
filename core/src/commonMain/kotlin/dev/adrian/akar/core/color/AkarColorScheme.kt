package dev.adrian.akar.core.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import dev.adrian.akar.core.color.token.ColorDarkTokens
import dev.adrian.akar.core.color.token.ColorLightTokens

@Immutable
data class AkarColorScheme(
    val primary: Color,
    val onPrimary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val surfaceVariant: Color,
    val surfaceContainerHigh: Color,
    val onSurface: Color,
    val onSurfaceVariant: Color,
    val outline: Color,
    val outlineVariant: Color,
    val error: Color,
    val inflow: Color,
    val outflow: Color,
    val interchange: Color
)

val akarDarkColorScheme = AkarColorScheme(
    primary = ColorDarkTokens.Primary,
    onPrimary = ColorDarkTokens.OnPrimary,
    background = ColorDarkTokens.Background,
    onBackground = ColorDarkTokens.OnBackground,
    surface = ColorDarkTokens.Surface,
    surfaceVariant = ColorDarkTokens.SurfaceVariant,
    surfaceContainerHigh = ColorDarkTokens.SurfaceContainerHigh,
    onSurface = ColorDarkTokens.OnSurface,
    onSurfaceVariant = ColorDarkTokens.OnSurfaceVariant,
    outline = ColorDarkTokens.Outline,
    outlineVariant = ColorDarkTokens.OutlineVariant,
    error = ColorDarkTokens.Error,
    inflow = ColorDarkTokens.Inflow,
    outflow = ColorDarkTokens.Outflow,
    interchange = ColorDarkTokens.Interchange
)

val akarLightColorScheme = AkarColorScheme(
    primary = ColorLightTokens.Primary,
    onPrimary = ColorLightTokens.OnPrimary,
    background = ColorLightTokens.Background,
    onBackground = ColorLightTokens.OnBackground,
    surface = ColorLightTokens.Surface,
    surfaceVariant = ColorLightTokens.SurfaceVariant,
    surfaceContainerHigh = ColorLightTokens.SurfaceContainerHigh,
    onSurface = ColorLightTokens.OnSurface,
    onSurfaceVariant = ColorLightTokens.OnSurfaceVariant,
    outline = ColorLightTokens.Outline,
    outlineVariant = ColorLightTokens.OutlineVariant,
    error = ColorLightTokens.Error,
    inflow = ColorLightTokens.Inflow,
    outflow = ColorLightTokens.Outflow,
    interchange = ColorLightTokens.Interchange
)

val LocalAkarColor = staticCompositionLocalOf<AkarColorScheme> {
    error("No color scheme provided")
}