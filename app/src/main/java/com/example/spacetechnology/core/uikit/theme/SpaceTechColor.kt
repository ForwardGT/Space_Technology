package com.example.spacetechnology.core.uikit.theme

import androidx.compose.ui.graphics.Color

object SpaceTechColor {

    //Default colors
    val black = Color(0xff000000)
    val background = Color(0xff2C3140)
    val backgroundText = Color(0xff333c4c)
    val navigationElement = Color(0xff5C6373)
    val gray = Color(0xffA4A5A6)
    val white = Color(0xffffffff)
    val red = Color(0xFFFF0000)
    private val darkRed = Color(0xffac1414)
    private val purple = Color(0xff4c2a70)
    private val lightPurple = Color(0xff8868a1)
    val green = Color(0xFF00FF00)

    //Gradients
    val buttonGradientDefault = listOf(navigationElement, gray)
    val buttonGradientFirstAuthScreen = listOf(purple, lightPurple)
    val buttonGradientDanger = listOf(red, darkRed)

}
