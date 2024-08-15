package com.example.spacetechnology.features.profile.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.spacetechnology.core.utils.API_KEY_NASA

@Composable
fun ApiKeyViewContent() {
    Column(
        modifier = Modifier
    ) {
        Text(text = "Api key = $API_KEY_NASA")
    }
}
