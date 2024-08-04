package com.example.spacetechnology.features.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.spacetechnology.features.nasa.data.network.apiKeyNasa

@Composable
fun ApiKeyViewContent() {
    Column(
        modifier = Modifier
    ) {
        Text(text = "Api key = $apiKeyNasa")
    }
}
