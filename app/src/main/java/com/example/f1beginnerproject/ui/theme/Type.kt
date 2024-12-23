package com.example.f1beginnerproject.ui.theme

import android.graphics.fonts.FontStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.f1beginnerproject.R

val TitilliumWeb = FontFamily(
    Font(R.font.titilliumweblight, FontWeight.Normal),
    Font(R.font.titilliumwebsemibolditalic,FontWeight.Bold),
    Font(R.font.titilliumwebsemibolditalic, FontWeight.Normal,
        androidx.compose.ui.text.font.FontStyle.Italic)

)
// Set of Material typography styles to start with

val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp

    ),
    displayLarge = TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    ),
    displayMedium =  TextStyle(
        fontFamily = TitilliumWeb,
        fontWeight = FontWeight.Normal,
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
        fontSize = 20.sp
    ),

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)