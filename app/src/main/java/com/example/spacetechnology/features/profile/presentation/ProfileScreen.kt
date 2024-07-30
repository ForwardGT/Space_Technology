package com.example.spacetechnology.features.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import com.example.spacetechnology.core.uikit.theme.SpaceTechnologyTheme

@Composable
fun ProfileScreen(
    navController: NavController
) {

    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            Text(text = "Profile")
        }
    }
}


@Preview
@Composable
fun Q() {
    SpaceTechnologyTheme(true) {
        ProfileScreen(navController = rememberNavController())
    }
}