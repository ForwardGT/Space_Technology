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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.extensions.thenIf

@Composable
fun LoadButton(
    onClick: () -> Unit,
    scroll: Boolean = false,
    label: String = "Try Again Load",
    defaultButton: Boolean = false
) {
    val viewWidth = with(LocalDensity.current) {
        (LocalView.current.rootView.height.toDp())
    }

    Box (
        Modifier
            .thenIf(!defaultButton, modifier = Modifier.fillMaxSize())
            .thenIf(scroll, modifier = Modifier.height(viewWidth))
    ) {
        Button(
            onClick = { onClick() },
            modifier = Modifier
                .height(40.dp)
                .width(130.dp)
                .align(Alignment.Center),
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
                    text = label,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}