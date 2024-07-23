package com.example.spacetechnology.features.spacex.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor

@Composable
fun DescriptionPost(
    description: String
) {
    Column(
        modifier = Modifier
            .background(SpaceTechColor.backgroundText)
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = SpaceTechColor.white,
            text = "Description:",
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = description,
            color = SpaceTechColor.white,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}