package com.example.spacetechnology.features.home.domain.entity

import androidx.compose.runtime.Composable
import com.example.spacetechnology.R
import com.example.spacetechnology.features.home.presentation.view.ClickableIcon
import com.example.spacetechnology.features.home.presentation.view.OneCard

class SpacexPostHomeLandPadImpl(
    private val description: String = "SpaceX landpad: a designated platform for rocket landings, equipped with guiding markers and the SpaceX logo, often located on ocean barges or coastal sites.",
    private val imagePreview: Int = R.drawable.landpads_preview
) : SpacePostHome, SpacexPostHomeRes() {

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