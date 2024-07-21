package com.example.spacetechnology.features.nasa.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar

@Composable
fun NasaScreen(
    navController: NavController
) {

    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            Text(text = "NASA")
        }
    }
}