package com.example.gallerie.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import com.example.gallerie.R


val DancingScript = FontFamily(
    Font(R.font.dancingscript_bold)
)

val Caveat = FontFamily(
    Font(R.font.caveat_medium)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    displayLarge = TextStyle(
        fontFamily = DancingScript,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),

    displayMedium = TextStyle(
        fontFamily = Caveat,
        fontWeight = FontWeight.Normal,
        fontSize = 35.sp
    ),

    displaySmall = TextStyle(
        fontFamily = Caveat,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    )

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