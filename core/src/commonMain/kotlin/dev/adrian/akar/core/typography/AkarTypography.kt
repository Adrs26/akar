package dev.adrian.akar.core.typography

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.adrian.akar.core.generated.resources.Res
import dev.adrian.akar.core.generated.resources.plus_jakarta_sans_bold
import dev.adrian.akar.core.generated.resources.plus_jakarta_sans_extra_bold
import dev.adrian.akar.core.generated.resources.plus_jakarta_sans_medium
import dev.adrian.akar.core.generated.resources.plus_jakarta_sans_regular
import dev.adrian.akar.core.generated.resources.plus_jakarta_sans_semi_bold
import org.jetbrains.compose.resources.Font

@Immutable
data class AkarTypography(
    val headingStandard: TextStyle,
    val headingSubtle: TextStyle,
    val titleFeatured: TextStyle,
    val titleStandard: TextStyle,
    val titleSubtle: TextStyle,
    val numberFeatured: TextStyle,
    val numberStandard: TextStyle,
    val numberSubtle: TextStyle,
    val bodyFeatured: TextStyle,
    val bodyStandard: TextStyle,
    val captionStandard: TextStyle,
    val labelFeatured: TextStyle,
    val labelStandard: TextStyle,
    val labelSubtle: TextStyle,
    val actionFeatured: TextStyle,
    val actionStandard: TextStyle,
    val actionSubtle: TextStyle
)

@Composable
private fun plusJakartaSansFontFamily() = FontFamily(
    Font(Res.font.plus_jakarta_sans_regular, FontWeight.Normal),
    Font(Res.font.plus_jakarta_sans_medium, FontWeight.Medium),
    Font(Res.font.plus_jakarta_sans_semi_bold, FontWeight.SemiBold),
    Font(Res.font.plus_jakarta_sans_bold, FontWeight.Bold),
    Font(Res.font.plus_jakarta_sans_extra_bold, FontWeight.ExtraBold)
)

@Composable
fun akarTypography() = AkarTypography(
    headingStandard = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        letterSpacing = 0.5.sp
    ),
    headingSubtle = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp
    ),
    titleFeatured = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        letterSpacing = 0.5.sp
    ),
    titleStandard = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    titleSubtle = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp
    ),
    numberFeatured = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.5.sp,
        fontFeatureSettings = "tnum"
    ),
    numberStandard = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        fontFeatureSettings = "tnum"
    ),
    numberSubtle = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        fontFeatureSettings = "tnum"
    ),
    bodyFeatured = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 21.sp
    ),
    bodyStandard = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 21.sp
    ),
    captionStandard = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 18.sp
    ),
    labelFeatured = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 18.sp
    ),
    labelStandard = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 18.sp
    ),
    labelSubtle = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 9.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 16.sp
    ),
    actionFeatured = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 21.sp
    ),
    actionStandard = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 18.sp
    ),
    actionSubtle = TextStyle(
        fontFamily = plusJakartaSansFontFamily(),
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 16.sp
    ),
)

val LocalAkarTypography = staticCompositionLocalOf<AkarTypography> {
    error("No typography provided")
}