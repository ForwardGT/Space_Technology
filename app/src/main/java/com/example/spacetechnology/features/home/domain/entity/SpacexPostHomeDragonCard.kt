package com.example.spacetechnology.features.home.domain.entity

import androidx.compose.runtime.Composable
import com.example.spacetechnology.R
import com.example.spacetechnology.features.home.presentation.view.ClickableIcon
import com.example.spacetechnology.features.home.presentation.view.OneCard

class SpacexPostHomeDragonCard(
    private val description: String = "Dragon spacecraft: Learn about the revolutionary vessels for cargo and crewed missions",
    private val imagePreview: Int = R.drawable.dragon_preview,
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