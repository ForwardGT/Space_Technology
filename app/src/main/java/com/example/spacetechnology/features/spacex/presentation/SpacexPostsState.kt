package com.example.spacetechnology.features.spacex.presentation

import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon
import com.example.spacetechnology.features.spacex.domain.entity.SpacexLandPads
import com.example.spacetechnology.features.spacex.domain.entity.SpacexRocket

data class SpacexPostsState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val loadingStateSpacexPosts: Int = 0,
    val postLandPads: SpacexLandPads? = null,
    val postRocket: SpacexRocket? = null,
    val postDragon: SpacexDragon? = null,
)
