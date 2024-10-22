package com.example.spacetechnology.features.shorts.presentation

import com.example.spacetechnology.R
import com.example.spacetechnology.features.shorts.domain.entity.ShortElement

data class ShortsState(
    val currentPage: Int = 0,
    val currentSpeedRewind: Long = 100,
    val rewindIconShow: Boolean = false,
    val shortElements: List<ShortElement> = listOf(
        ShortElement(currentProgressIndicator = 0f, urlImage = R.drawable.image1),
        ShortElement(currentProgressIndicator = 0f, urlImage = R.drawable.image2),
        ShortElement(currentProgressIndicator = 0f, urlImage = R.drawable.image3),
        ShortElement(currentProgressIndicator = 0f, urlImage = R.drawable.image4),
        ShortElement(currentProgressIndicator = 0f, urlImage = R.drawable.image5)
    )
)
