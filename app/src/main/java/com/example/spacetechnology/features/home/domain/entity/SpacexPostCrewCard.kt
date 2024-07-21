package com.example.spacetechnology.features.home.domain.entity

import androidx.compose.runtime.Composable
import com.example.spacetechnology.R
import com.example.spacetechnology.features.home.presentation.view.ClickableIcon
import com.example.spacetechnology.features.home.presentation.view.OneCard

class SpacexPostCrewCard(
    private val description: String = "Meet the astronauts: Discover the heroes embarking on SpaceX missions.",
    private val imagePreview: Int = R.drawable.crew_preview
) : SpacePost, SpacexPostRes() {

    @Composable
    override fun Post() {
        OneCard(
            imagePreview = imagePreview,
            description = description
        ) {
            ClickableIcon(
                pathIcon = pathIcon,
                pathUrl = pathUrl
            )
        }
    }
}