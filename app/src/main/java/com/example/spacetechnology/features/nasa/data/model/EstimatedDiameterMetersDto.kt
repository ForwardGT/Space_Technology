package com.example.spacetechnology.features.nasa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class EstimatedDiameterMetersDto(
    val estimated_diameter_min: Double,
    val estimated_diameter_max: Double,
)