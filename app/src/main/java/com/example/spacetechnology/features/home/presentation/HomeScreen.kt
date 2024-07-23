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
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.features.home.domain.entity.SpacexPostHomeDragonImpl
import com.example.spacetechnology.features.home.domain.entity.SpacexPostHomeLandPadImpl
import com.example.spacetechnology.features.home.domain.entity.SpacexPostHomeRocketImpl
import com.example.spacetechnology.features.home.presentation.view.CardsSpacex
import com.example.spacetechnology.features.home.presentation.view.SpaceTechTopBar

@Composable
fun HomeScreen(
    navController: NavController
) {
    val spacexPost = listOf(
        SpacexPostHomeRocketImpl(),
        SpacexPostHomeDragonImpl(),
        SpacexPostHomeLandPadImpl()
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