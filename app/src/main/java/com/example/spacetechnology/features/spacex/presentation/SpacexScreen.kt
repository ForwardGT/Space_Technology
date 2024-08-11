package com.example.spacetechnology.features.spacex.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.utils.view.CustomButton
import com.example.spacetechnology.core.utils.view.CustomCircleProgressIndicator
import com.example.spacetechnology.core.utils.view.MediumPreviewPosts
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
                    CustomButton(
                        onClick = { viewModel.loadAllPost() },
                        scroll = true
                    )
                }

                loadingState -> {
                    CustomCircleProgressIndicator(needHeightScreen = true)
                }

                else -> {
                    state.postDragon?.let { dragon ->
                        MediumPreviewPosts(
                            description = dragon.description,
                            image = dragon.image,
                            titlePost = "Last Dragon"
                        )
                    }
                    state.postRocket?.let { rocket ->
                        MediumPreviewPosts(
                            description = rocket.description,
                            image = rocket.image,
                            titlePost = "Last Rocket"
                        )
                    }
                    state.postLandPads?.let { landPad ->
                        MediumPreviewPosts(
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