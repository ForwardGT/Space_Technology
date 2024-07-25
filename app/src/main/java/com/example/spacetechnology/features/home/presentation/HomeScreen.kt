package com.example.spacetechnology.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spacetechnology.R
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.features.home.domain.entity.HomeScreenPostImpl
import com.example.spacetechnology.features.home.presentation.view.CardsPreviewSpaceTech
import com.example.spacetechnology.features.home.presentation.view.SpaceTechTopBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    val spacexPosts = listOf(
        HomeScreenPostImpl(
            description = "Rockets SpaceX: Explore SpaceX's innovative designs and powerful launch vehicles.",
            imagePreview = R.drawable.rocket_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = "https://www.spacex.com"
        ),
        HomeScreenPostImpl(
            description = "Dragon spacecraft SpaceX: Learn about the revolutionary vessels for cargo and crewed missions",
            imagePreview = R.drawable.dragon_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = "https://www.spacex.com"
        ),
        HomeScreenPostImpl(
            description = "Landpad SpaceX: A designated platform for rocket landings, equipped with guiding markers and the SpaceX logo, often located on ocean barges or coastal sites.",
            imagePreview = R.drawable.landpads_preview,
            pathIcon = R.drawable.spacex_logo,
            pathUrl = "https://www.spacex.com"
        )
    )

    val nasaPosts = listOf(
        HomeScreenPostImpl(
            description = "Last news NASA: Catch up on today's top news and major world events",
            imagePreview = R.drawable.last_news_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = "https://www.nasa.gov/"
        ),
        HomeScreenPostImpl(
            description = "Technologies NASA: Explore NASA's groundbreaking technologies transforming space and Earth.",
            imagePreview = R.drawable.tehnology_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = "https://www.nasa.gov/"
        ),
        HomeScreenPostImpl(
            description = "Asteroids NASA: Uncover the secrets of asteroids: their origins, orbits, and potential Earth impacts.",
            imagePreview = R.drawable.asteroids_nasa,
            pathIcon = R.drawable.nasa_logo,
            pathUrl = "https://www.nasa.gov/"
        )
    )

    Scaffold(
        topBar = {
            SpaceTechTopBar()
        },
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(top = 10.dp)
        ) {

            CardsPreviewSpaceTech(spacexPosts, nasaPosts)

        }
    }
}