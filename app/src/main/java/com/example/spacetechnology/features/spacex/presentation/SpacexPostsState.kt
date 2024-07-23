package com.example.spacetechnology.features.spacex.presentation

import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket

data class SpacexPostsState(
    val isLoadingLandPads: Boolean = false,
    val isLoadingRockets: Boolean = false,
    val isLoadingDragon: Boolean = false,
    val postLandPads: SpacexLandPads? = null,
    val postRocket: SpacexRocket? = null,
    val postDragon: SpacexDragon? = null,
    val loadingStateSpacexPosts: Int = 0,
    val isError: Boolean = false,
)
