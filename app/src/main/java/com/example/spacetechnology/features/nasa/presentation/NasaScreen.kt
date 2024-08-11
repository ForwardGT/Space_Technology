package com.example.spacetechnology.features.nasa.presentation

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
fun NasaScreen(
    navController: NavController
) {
    val viewModel: ViewModelNasa = koinViewModel()
    val state by viewModel.state.collectAsState()

    val errorStateDragon = state.isError || state.postsApod == null && !state.isLoadingPostApod
    val errorStateRocket = state.isError || state.postsAsteroids == null && !state.isLoadingPostAsteroids
    val errorStateLandPads = state.isError || state.postsTechTransfer == null && !state.isLoadingPostTechTransfer
    val loadingState = state.isLoadingPostApod || state.isLoadingPostAsteroids || state.isLoadingPostTechTransfer

    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            when {
                errorStateLandPads || errorStateRocket || errorStateDragon -> {
                    CustomButton(
                        onClick = { viewModel.loadAllPosts() },
                        scroll = true
                    )
                }

                loadingState -> {
                    CustomCircleProgressIndicator(true)
                }

                else -> {
                    state.postsTechTransfer?.let { tech ->
                        MediumPreviewPosts(
                            image = listOf(tech.image),
                            description = tech.description,
                            titlePost = "Last tech transfer"
                        )

                    }
                    state.postsApod?.let { apod ->
                        MediumPreviewPosts(
                            image = listOf(apod.urlImage),
                            description = apod.description,
                            titlePost = "Last APOD"
                        )
                    }
                    state.postsAsteroids?.let { asteroid ->
                        MediumPreviewPosts(
                            image = listOf("https://science.nasa.gov/wp-content/uploads/2023/09/pia24471-modest.jpg?w=2048&format=webp"),
                            description = asteroid.orbitClassDescription,
                            titlePost = "Last noticed asteroid"
                        )
                    }
                }
            }
        }
    }
}