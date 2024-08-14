package com.example.spacetechnology.core.utils.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.spacetechnology.core.uikit.theme.SpaceTechColor
import com.example.spacetechnology.features.spacex.presentation.view.DescriptionPost
import com.example.spacetechnology.features.spacex.presentation.view.PhotoCarousel
import com.example.spacetechnology.features.spacex.presentation.view.TitleWithLines

@Composable
fun MediumPreviewPosts(
    image: List<String>,
    description: String,
    titlePost: String,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        border = BorderStroke(1.dp, SpaceTechColor.navigationElement),
    ) {
        TitleWithLines(titlePost)

        if (image.isNotEmpty()) PhotoCarousel(image) else Unit

        DescriptionPost(description)
    }
}