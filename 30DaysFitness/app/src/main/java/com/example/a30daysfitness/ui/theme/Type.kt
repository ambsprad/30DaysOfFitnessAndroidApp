package com.example.a30daysfitness.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp


import androidx.compose.ui.text.googlefonts.Font
import com.example.a30daysfitness.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val bodyFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Exo 2"),
        fontProvider = com.example.a30daysfitness.ui.theme.provider,
    )
)

val displayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Exo 2"),
        fontProvider = provider,
    )
)

// Default Material 3 typography values
val baseline = Typography()

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = com.example.a30daysfitness.ui.theme.baseline.displayLarge.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    displayMedium = com.example.a30daysfitness.ui.theme.baseline.displayMedium.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    displaySmall = com.example.a30daysfitness.ui.theme.baseline.displaySmall.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    headlineLarge = com.example.a30daysfitness.ui.theme.baseline.headlineLarge.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    headlineMedium = com.example.a30daysfitness.ui.theme.baseline.headlineMedium.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    headlineSmall = com.example.a30daysfitness.ui.theme.baseline.headlineSmall.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    titleLarge = com.example.a30daysfitness.ui.theme.baseline.titleLarge.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    titleMedium = com.example.a30daysfitness.ui.theme.baseline.titleMedium.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    titleSmall = com.example.a30daysfitness.ui.theme.baseline.titleSmall.copy(fontFamily = com.example.a30daysfitness.ui.theme.displayFontFamily),
    bodyLarge = com.example.a30daysfitness.ui.theme.baseline.bodyLarge.copy(fontFamily = com.example.a30daysfitness.ui.theme.bodyFontFamily),
    bodyMedium = com.example.a30daysfitness.ui.theme.baseline.bodyMedium.copy(fontFamily = com.example.a30daysfitness.ui.theme.bodyFontFamily),
    bodySmall = com.example.a30daysfitness.ui.theme.baseline.bodySmall.copy(fontFamily = com.example.a30daysfitness.ui.theme.bodyFontFamily),
    labelLarge = com.example.a30daysfitness.ui.theme.baseline.labelLarge.copy(fontFamily = com.example.a30daysfitness.ui.theme.bodyFontFamily),
    labelMedium = com.example.a30daysfitness.ui.theme.baseline.labelMedium.copy(fontFamily = com.example.a30daysfitness.ui.theme.bodyFontFamily),
    labelSmall = com.example.a30daysfitness.ui.theme.baseline.labelSmall.copy(fontFamily = com.example.a30daysfitness.ui.theme.bodyFontFamily),
)