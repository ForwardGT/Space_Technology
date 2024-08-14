package com.example.spacetechnology.features.nasa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class EstimatedDiameterDto(
    val meters: EstimatedDiameterMetersDto
)