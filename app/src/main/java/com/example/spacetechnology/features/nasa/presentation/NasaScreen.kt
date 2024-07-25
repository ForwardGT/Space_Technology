package com.example.spacetechnology.features.nasa.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.spacetechnology.core.uikit.navigation.SpaceTechNavigationBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun NasaScreen(
    navController: NavController
) {
    val viewModel: ViewModelNasa = koinViewModel()
    val lastPostApod by viewModel.lastPostApod.collectAsState()
    val lastTech by viewModel.lastPostTechTransfer.collectAsState()

    Scaffold(
        bottomBar = {
            SpaceTechNavigationBar(navController)
        }
    ) { paddingValues ->
        LazyColumn(
            Modifier
                .padding(paddingValues)
        ) {
            items(lastTech) {
                Text(text = it.name)
                Text(text = it.description)
                AsyncImage(model = it.image, contentDescription = null)
            }
        }
    }
}