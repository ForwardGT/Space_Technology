package com.example.spacetechnology.features.home.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor

@Composable
fun OneCardForMainScreen(
    imagePreview: Any,
    description: String,
    compFun: @Composable () -> Unit,
) {
    val viewWidth = with(LocalDensity.current) {
        (LocalView.current.rootView.width.toDp() - 40.dp)
    }

    Box(
        modifier = Modifier
            .height(300.dp)
            .width(viewWidth)
            .padding(start = 10.dp)
            .clip(shape = RoundedCornerShape(8.dp)),
    ) {

        when (imagePreview) {
            is Int -> Image(
                painter = painterResource(id = imagePreview),
                alignment = Alignment.Center,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            is String -> AsyncImage(
                model = imagePreview,
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, SpaceTechColor.black),
                        startY = 550f,
                        endY = 730f
                    )
                )
        ) {
            compFun()

            Text(
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = SpaceTechColor.white,
                text = description,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
            )
        }
    }
}