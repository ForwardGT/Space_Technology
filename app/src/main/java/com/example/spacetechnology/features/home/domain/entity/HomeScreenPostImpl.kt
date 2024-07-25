package com.example.spacetechnology.features.home.domain.entity

import androidx.compose.runtime.Composable
import com.example.spacetechnology.features.home.presentation.view.ClickableIcon
import com.example.spacetechnology.features.home.presentation.view.OneCard

class HomeScreenPostImpl(
    private val description: String,
    private val imagePreview: Int,
    private val pathIcon: Int,
    private val pathUrl: String,
) : SpacePostHome {

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