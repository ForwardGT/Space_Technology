package com.example.spacetechnology.features.home.domain.entity

import androidx.compose.runtime.Composable
import com.example.spacetechnology.R
import com.example.spacetechnology.features.home.presentation.view.ClickableIcon
import com.example.spacetechnology.features.home.presentation.view.OneCard

class SpacexPostHomeRocketImpl(
    private val description: String = "Rockets: Explore SpaceX's innovative designs and powerful launch vehicles.",
    private val imagePreview: Int = R.drawable.rocket_preview,
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