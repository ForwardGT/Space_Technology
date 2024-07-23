package com.example.spacetechnology.core.utils


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor

@Composable
fun CirProgIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SpaceTechColor.background),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun P() {
    CirProgIndicator()
}