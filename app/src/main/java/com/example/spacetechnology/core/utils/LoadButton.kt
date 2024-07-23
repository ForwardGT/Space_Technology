package com.example.spacetechnology.core.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor

@Composable
fun LoadButton(
    onClick: () -> Unit
) {

    Box {
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .height(40.dp)
                .width(130.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            SpaceTechColor.buttonGradient
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    color = SpaceTechColor.white,
                    text = "Try Again Load",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview
@Composable
fun Q() {
    LoadButton {

    }
}