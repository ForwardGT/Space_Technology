package com.example.spacetechnology.features.shorts.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.features.shorts.presentation.view.HeaderShortsProfileBar
import com.example.spacetechnology.features.shorts.presentation.view.RewindShortsIcon
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortsScreen(navController: NavController) {

    val viewModel: ViewModelShorts = koinViewModel()
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(pageCount = {
        state.shortElements.size
    })

    LaunchedEffect(state.currentPage) {
        pagerState.animateScrollToPage(page = state.currentPage)
        viewModel.launchScrollNextPage(
            totalPages = state.shortElements.size,
            currentPageIndex = pagerState.currentPage
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { SpaceTechNavigationBar(navController) }
    ) { paddingValues ->

        Box(Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(10.dp)
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                viewModel.rewind(true)
                                val longPressSucceeded = tryAwaitRelease()
                                if (longPressSucceeded) {
                                    viewModel.rewind(false)
                                }
                            },
                        )
                    }
            ) {
                ProgressIndicatorShorts(state)

                Spacer(modifier = Modifier.padding(top = 4.dp))

                Box(modifier = Modifier.fillMaxSize()) {
                    ShortsPager(state, pagerState)
                    HeaderShortsProfileBar()
                }
            }
            if (state.rewindIconShow) {
                RewindShortsIcon()
            }
        }
    }
}


@Composable
private fun ProgressIndicatorShorts(
    state: ShortsState
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(3.dp),
    ) {
        state.shortElements.forEach { indicator ->
            LinearProgressIndicator(
                color = Color(0xffabc8c7),
                modifier = Modifier.weight(1f),
                strokeCap = StrokeCap.Round,
                progress = {
                    indicator.currentProgressIndicator
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ShortsPager(
    state: ShortsState,
    pagerState: PagerState
) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
    ) { page ->
        Card {
            val shortElement = state.shortElements[page]
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = shortElement.urlImage),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}