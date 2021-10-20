package com.almogdadjabir.hifi.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.almogdadjabir.hifi.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)


//val GilroyRegular = FontFamily(
//Font(R.font.Gilroy_Regular)
//)
//
//val GilroyLight = FontFamily(
//Font(R.font.Gilroy_Light)
//)
//
//val GilroyThin = FontFamily(
//Font(R.font.Gilroy_Thin)
//)
//
//val GilroyBlack = FontFamily(
//Font(R.font.Gilroy_Black)
//)
val poppins_black = FontFamily(
    Font(R.font.poppins_black)
)

val poppins_regular = FontFamily(
    Font(R.font.poppins_regular)
)