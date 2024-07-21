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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme
import com.example.spacetechnology.features.home.domain.entity.SpacexPostCrewCard
import com.example.spacetechnology.features.home.domain.entity.SpacexPostDragonCard
import com.example.spacetechnology.features.home.domain.entity.SpacexPostRocketCard
import com.example.spacetechnology.features.home.presentation.view.CardsSpacex
import com.example.spacetechnology.features.home.presentation.view.SpaceTechTopBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    val spacexPost = listOf(
        SpacexPostCrewCard(),
        SpacexPostRocketCard(),
        SpacexPostDragonCard()
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

            CardsSpacex(spacexPost)

        }
    }
}

@Preview
@Composable
private fun P() {
    SpaceTechnologyTheme(true) {
        HomeScreen(navController = rememberNavController())
    }
}