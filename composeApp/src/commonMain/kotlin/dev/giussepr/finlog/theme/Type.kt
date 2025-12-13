package dev.giussepr.finlog.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import finlog.composeapp.generated.resources.Res
import finlog.composeapp.generated.resources.manrope_bold
import finlog.composeapp.generated.resources.manrope_extra_bold
import finlog.composeapp.generated.resources.manrope_extra_light
import finlog.composeapp.generated.resources.manrope_light
import finlog.composeapp.generated.resources.manrope_medium
import finlog.composeapp.generated.resources.manrope_regular
import finlog.composeapp.generated.resources.manrope_semibold
import org.jetbrains.compose.resources.Font

private object Fonts {
    val BodyFontFamily
        @Composable get() = FontFamily(
            Font(resource = Res.font.manrope_bold, weight = FontWeight.Bold),
            Font(resource = Res.font.manrope_extra_bold, weight = FontWeight.ExtraBold),
            Font(resource = Res.font.manrope_extra_light, weight = FontWeight.ExtraLight),
            Font(resource = Res.font.manrope_light, weight = FontWeight.Light),
            Font(resource = Res.font.manrope_medium, weight = FontWeight.Medium),
            Font(resource = Res.font.manrope_regular, weight = FontWeight.Normal),
            Font(resource = Res.font.manrope_semibold, weight = FontWeight.SemiBold)
        )

    val DisplayFontFamily
        @Composable get() = FontFamily(
            Font(resource = Res.font.manrope_bold, weight = FontWeight.Bold),
            Font(resource = Res.font.manrope_extra_bold, weight = FontWeight.ExtraBold),
            Font(resource = Res.font.manrope_extra_light, weight = FontWeight.ExtraLight),
            Font(resource = Res.font.manrope_light, weight = FontWeight.Light),
            Font(resource = Res.font.manrope_medium, weight = FontWeight.Medium),
            Font(resource = Res.font.manrope_regular, weight = FontWeight.Normal),
            Font(resource = Res.font.manrope_semibold, weight = FontWeight.SemiBold)
        )
}

// Default Material 3 typography values
val baseline = Typography()

val AppTypography: Typography
    @Composable get() = Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = Fonts.DisplayFontFamily),
        displayMedium = baseline.displayMedium.copy(fontFamily = Fonts.DisplayFontFamily),
        displaySmall = baseline.displaySmall.copy(fontFamily = Fonts.DisplayFontFamily),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = Fonts.DisplayFontFamily),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = Fonts.DisplayFontFamily),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = Fonts.DisplayFontFamily),
        titleLarge = baseline.titleLarge.copy(fontFamily = Fonts.DisplayFontFamily),
        titleMedium = baseline.titleMedium.copy(fontFamily = Fonts.DisplayFontFamily),
        titleSmall = baseline.titleSmall.copy(fontFamily = Fonts.DisplayFontFamily),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = Fonts.BodyFontFamily),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = Fonts.BodyFontFamily),
        bodySmall = baseline.bodySmall.copy(fontFamily = Fonts.BodyFontFamily),
        labelLarge = baseline.labelLarge.copy(fontFamily = Fonts.BodyFontFamily),
        labelMedium = baseline.labelMedium.copy(fontFamily = Fonts.BodyFontFamily),
        labelSmall = baseline.labelSmall.copy(fontFamily = Fonts.BodyFontFamily),
    )
