package com.example.spacetechnology.features.spacex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LandPadsInformationImageDto(
    val large: List<String>
)
