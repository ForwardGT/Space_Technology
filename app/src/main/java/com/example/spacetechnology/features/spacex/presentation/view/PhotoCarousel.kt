package com.example.spacetechnology.features.spacex.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.spacetechnology.core.utils.CirProgIndicator

@Composable
fun PhotoCarousel(
    imageList: List<String>
) {
    val viewWidth = with(LocalDensity.current) {
        (LocalView.current.rootView.width.toDp())
    }

    LazyRow {
        items(imageList) { image ->
            Box(
                modifier = Modifier
                    .height(250.dp)
                    .width(viewWidth)
            ) {
                SubcomposeAsyncImage(
                    model = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val state = painter.state

                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        CirProgIndicator()
                    } else {
                        SubcomposeAsyncImageContent()
                    }
                }
            }
        }
    }
}