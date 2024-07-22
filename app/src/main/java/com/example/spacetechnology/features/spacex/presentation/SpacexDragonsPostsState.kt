package com.example.spacetechnology.features.spacex.presentation

import com.example.spacetechnology.features.spacex.domain.entity.SpacexDragon

data class SpacexDragonsPostsState(
    val isLoading: Boolean = false,
    val post: SpacexDragon? = null,
    val isError: Boolean = false
)
