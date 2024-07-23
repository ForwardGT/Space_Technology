package com.example.spacetechnology.features.spacex.presentation.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.CustomSpacer

@Composable
fun TitleWithLines(
    title: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(SpaceTechColor.backgroundText)
            .padding(2.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            LineSpacer()
        }
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier,
            color = SpaceTechColor.white,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.SemiBold
        )
        Column(
            horizontalAlignment = Alignment.End
        ) {
            LineSpacer()
        }
    }
}

@Composable
private fun Line(width: Dp) {
    Canvas(
        modifier = Modifier
            .height(2.dp)
            .width(width)
    ) {
        drawLine(
            color = SpaceTechColor.white,
            start = Offset(size.width, size.height / 2),
            end = Offset(0f, size.height / 2),
            strokeWidth = 4f
        )
    }
}

@Composable
fun LineSpacer() {
    Line(80.dp)
    CustomSpacer(v = 2.dp)
    Line(60.dp)
    CustomSpacer(v = 2.dp)
    Line(40.dp)
    CustomSpacer(v = 2.dp)
    Line(20.dp)
}