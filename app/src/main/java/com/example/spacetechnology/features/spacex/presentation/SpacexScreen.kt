package com.example.spacetechnology.features.spacex.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.core.utils.CirProgIndicator
import com.example.spacetechnology.core.utils.LoadButton
import com.example.spacetechnology.features.spacex.presentation.view.DescriptionPost
import com.example.spacetechnology.features.spacex.presentation.view.PhotoCarousel
import com.example.spacetechnology.features.spacex.presentation.view.TitleWithLines
import org.koin.androidx.compose.koinViewModel

@Composable
fun SpacexScreen(
    navController: NavController
) {
    val viewModel: ViewModelSpacex = koinViewModel()
    val state by viewModel.state.collectAsState()

    val errorStateDragon = state.isError || state.postDragon == null && !state.isLoadingDragon
    val errorStateRocket = state.isError || state.postRocket == null && !state.isLoadingRockets
    val errorStateLandPads = state.isError || state.postLandPads == null && !state.isLoadingLandPads
    val loadingState = state.isLoadingDragon || state.isLoadingRockets || state.isLoadingLandPads

    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            when {
                errorStateRocket || errorStateDragon || errorStateLandPads -> {
                    LoadButton(
                        onClick = { viewModel.loadAllPost() },
                        scroll = true
                    )
                }

                loadingState -> {
                    CirProgIndicator(needHeightScreen = true)
                }

                else -> {
                    state.postDragon?.let { dragon ->
                        PostsSpacex(
                            description = dragon.description,
                            image = dragon.image,
                            titlePost = "Last Dragon"
                        )
                    }
                    state.postRocket?.let { rocket ->
                        PostsSpacex(
                            description = rocket.description,
                            image = rocket.image,
                            titlePost = "Last Rocket"
                        )
                    }
                    state.postLandPads?.let { landPad ->
                        PostsSpacex(
                            description = landPad.description,
                            image = landPad.image,
                            titlePost = "Last Land Pads"
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun PostsSpacex(
    image: List<String>,
    description: String,
    titlePost: String
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        border = BorderStroke(2.dp, SpaceTechColor.navigationElement),
        modifier = Modifier
            .padding(6.dp)
    ) {
        TitleWithLines(titlePost)
        PhotoCarousel(image)
        DescriptionPost(description)
    }
}
