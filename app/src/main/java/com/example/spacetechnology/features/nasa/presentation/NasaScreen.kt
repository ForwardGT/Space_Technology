package com.example.spacetechnology.features.nasa.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    val postApod by viewModel.postApod.collectAsState()

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
            AsyncImage(model = postApod.urlImage, contentDescription = null)
            Text(text = "${postApod.date} \n ${postApod.title} \n ${postApod.explanation}")
        }
    }
}