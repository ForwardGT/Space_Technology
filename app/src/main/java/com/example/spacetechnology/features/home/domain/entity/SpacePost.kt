package com.example.spacetechnology.features.home.domain.entity

import androidx.compose.runtime.Composable

sealed interface SpacePost {

    @Composable
    fun Post()
}
