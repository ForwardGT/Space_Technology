package com.example.spacetechnology.features.home.domain.entity

import androidx.compose.runtime.Composable
import com.example.spacetechnology.features.home.presentation.view.CustomClickableIcon
import com.example.spacetechnology.features.home.presentation.view.OneCardForMainScreen

class HomeScreenPostImpl(
    private val description: String,
    private val imagePreview: Int,
    private val pathIcon: Int,
    private val pathUrl: String,
) : SpacePostHome {

    @Composable
    override fun Post() {
        OneCardForMainScreen(
            imagePreview = imagePreview,
            description = description,
            compFun = {
                CustomClickableIcon(
                    pathIcon = pathIcon,
                    pathUrl = pathUrl
                )
            }
        )
    }
}