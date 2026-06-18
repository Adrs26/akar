package dev.adrian.akar.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import dev.adrian.akar.core.color.AkarColorScheme
import dev.adrian.akar.core.color.LocalAkarColor
import dev.adrian.akar.core.color.akarDarkColorScheme
import dev.adrian.akar.core.color.akarLightColorScheme
import dev.adrian.akar.core.shape.AkarShape
import dev.adrian.akar.core.shape.LocalAkarShape
import dev.adrian.akar.core.shape.akarShape
import dev.adrian.akar.core.spacing.AkarSpacing
import dev.adrian.akar.core.spacing.LocalAkarSpacing
import dev.adrian.akar.core.spacing.akarSpacing
import dev.adrian.akar.core.typography.AkarTypography
import dev.adrian.akar.core.typography.LocalAkarTypography
import dev.adrian.akar.core.typography.akarTypography
import dev.tclement.fonticons.LocalIconFont
import dev.tclement.fonticons.LocalIconTint
import dev.tclement.fonticons.VariableIconFont

@Composable
fun AkarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    icon: VariableIconFont? = null,
    content: @Composable () -> Unit,
) {
    val akarColorScheme = if (darkTheme) akarDarkColorScheme else akarLightColorScheme
    val materialColorScheme = when {
        darkTheme -> {
            darkColorScheme(
                primary = akarColorScheme.primary,
                onPrimary = akarColorScheme.onPrimary,
                background = akarColorScheme.background,
                onBackground = akarColorScheme.onBackground,
                surface = akarColorScheme.surface,
                surfaceContainerHigh = akarColorScheme.surface,
                onSurface = akarColorScheme.onSurface,
                inverseOnSurface = akarColorScheme.surface,
                error = akarColorScheme.error,
            )
        }
        else -> {
            lightColorScheme(
                primary = akarColorScheme.primary,
                onPrimary = akarColorScheme.onPrimary,
                background = akarColorScheme.background,
                onBackground = akarColorScheme.onBackground,
                surface = akarColorScheme.surface,
                surfaceContainerHigh = akarColorScheme.surface,
                onSurface = akarColorScheme.onSurface,
                inverseOnSurface = akarColorScheme.surface,
                error = akarColorScheme.error,
            )
        }
    }

    val materialTypography = Typography(
        bodyLarge = akarTypography().bodyFeatured,
        bodyMedium = akarTypography().labelFeatured,
        labelMedium = akarTypography().labelStandard,
        labelSmall = akarTypography().labelSubtle
    )

    if (icon != null) {
        CompositionLocalProvider(
            LocalAkarColor provides akarColorScheme,
            LocalAkarShape provides akarShape,
            LocalAkarTypography provides akarTypography(),
            LocalAkarSpacing provides akarSpacing,
            LocalIconFont provides icon,
            LocalIconTint provides akarColorScheme.onSurface
        ) {
            MaterialTheme(
                colorScheme = materialColorScheme,
                motionScheme = MaterialTheme.motionScheme,
                shapes = MaterialTheme.shapes,
                typography = materialTypography,
                content = content
            )
        }
    } else {
        CompositionLocalProvider(
            LocalAkarColor provides akarColorScheme,
            LocalAkarShape provides akarShape,
            LocalAkarTypography provides akarTypography(),
            LocalAkarSpacing provides akarSpacing
        ) {
            MaterialTheme(
                colorScheme = materialColorScheme,
                motionScheme = MaterialTheme.motionScheme,
                shapes = MaterialTheme.shapes,
                typography = materialTypography,
                content = content
            )
        }
    }
}

object AkarTheme {

    val colors: AkarColorScheme
        @Composable @ReadOnlyComposable get() = LocalAkarColor.current

    val shapes: AkarShape
        @Composable @ReadOnlyComposable get() = LocalAkarShape.current

    val typography: AkarTypography
        @Composable @ReadOnlyComposable get() = LocalAkarTypography.current

    val spacing: AkarSpacing
        @Composable @ReadOnlyComposable get() = LocalAkarSpacing.current
}