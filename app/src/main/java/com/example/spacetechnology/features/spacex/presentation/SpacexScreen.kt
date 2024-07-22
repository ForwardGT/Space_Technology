package com.example.spacetechnology.features.spacex.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.presentation.view.TitleWithLines
import org.koin.androidx.compose.koinViewModel

@Composable
fun SpacexScreen(
    navController: NavController
) {
    val viewModel: ViewModelSpacex = koinViewModel()
    val state by viewModel.state.collectAsState()

    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->

        Column(
            Modifier
                .padding(paddingValues)
                .border(2.dp, SpaceTechColor.navigationElement)
        ) {
            when {
                state.isError || state.post == null && !state.isLoading -> {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        //TODO написать кнопку для обновления экрана
                    }
                }

                state.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                else -> state.post?.also { post ->

                    TitleWithLines("Last Dragon")

                    PhotoCarousel(post)

                    DescriptionPost(post)

                }
            }
        }
    }
}


@Composable
fun PhotoCarousel(
    post: SpacexDragon
) {

    val viewWidth = with(LocalDensity.current) {
        (LocalView.current.rootView.width.toDp())
    }

    LazyRow {
        items(post.image) {
            Box(
                modifier = Modifier
                    .height(250.dp)
                    .width(viewWidth)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = it,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}


@Composable
fun DescriptionPost(
    post: SpacexDragon
) {


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Description"
        )
        Text(text = post.description)
    }
}


@Preview
@Composable
fun Tqq() {
    SpaceTechnologyTheme(darkTheme = true) {
        TitleWithLines("Hello")
    }
}

