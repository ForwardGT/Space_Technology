package com.example.spacetechnology.features.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.ui.theme.SpaceTechnologyTheme
import com.example.spacetechnology.features.home.presentation.view.SpaceTechNavigationBar
import com.example.spacetechnology.features.home.presentation.view.SpaceTechTopBar

@Composable
fun HomeScreen(
    navController: NavController
) {

    Scaffold(
        topBar = {
            SpaceTechTopBar()
        },
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            Text(text = "Home")
        }
    }
}

@Preview
@Composable
private fun P() {
    SpaceTechnologyTheme (true) {
        HomeScreen(navController = rememberNavController())
    }
}