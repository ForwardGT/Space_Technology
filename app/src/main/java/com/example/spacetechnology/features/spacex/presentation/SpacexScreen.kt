package com.example.spacetechnology.features.spacex.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.core.utils.CustomSpacer
import org.koin.androidx.compose.koinViewModel

@Composable
fun SpacexScreen(
    navController: NavController
) {
    val viewModel: SpacexViewModel = koinViewModel()
    val postDragon by viewModel.postDragon.collectAsState()
    val images = if (postDragon.isNotEmpty()) postDragon.map { it.image }.last() else listOf()
//    val images = postDragon.map { it.image }.last()
    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->

        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            TitleWithLines("Hello")


            PhotoCarousel(images)
        }
    }
}

@Composable
fun TitleWithLines(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Line(70.dp)
            CustomSpacer(v = 5.dp)
            Line(50.dp)
            CustomSpacer(v = 5.dp)
            Line(70.dp)
        }

        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier,
            color = Color.White
        )
        Column {
            Line(50.dp)
            CustomSpacer(v = 5.dp)
            Line(30.dp)
            CustomSpacer(v = 5.dp)
            Line(50.dp)
        }
    }
}

@Composable
fun Line(width: Dp) {
    Canvas(
        modifier = Modifier
            .height(2.dp)
            .width(width)
    ) {
        drawLine(
            color = Color.White,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = 4f
        )
    }
}

@Composable
fun Line2(width: Dp) {
    Canvas(
        modifier = Modifier
            .height(2.dp)
            .width(width)
    ) {
        drawLine(
            color = Color.White,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = 4f
        )
    }
}


@Composable
fun PhotoCarousel(
    images: List<String>
) {
    LazyRow {
        items(images) {
            SubcomposeAsyncImage(
                model = it,
                success = {
                    CircularProgressIndicator()
                },
                contentDescription = null
            )
        }
    }
}


@Preview
@Composable
fun Tqq() {
    SpaceTechnologyTheme(darkTheme = true) {
        TitleWithLines("Hello")
    }
}

